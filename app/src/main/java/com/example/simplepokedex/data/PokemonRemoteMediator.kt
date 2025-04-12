package com.example.simplepokedex.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.library.persistent.converter.Types
import com.example.library.networking.client.pokemon.PokemonClient
import com.example.library.networking.client.pokemon.request.GetPokemonByNameRequest
import com.example.library.networking.client.pokemon.request.GetPokemonListRequest
import com.example.library.persistent.PokedexDatabase
import com.example.library.persistent.entity.PokemonEntity
import com.example.library.persistent.entity.PokemonRemoteKeys

@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator(
    private val database: PokedexDatabase,
    private val client: PokemonClient,
) : RemoteMediator<Int, PokemonEntity>(){

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    private companion object {
        const val INITIAL_OFFSET = 0
        const val REQUEST_LIMIT = 5
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, PokemonEntity>): PokemonRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { data ->
            database.remoteKeysDao().get(data.name)
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, PokemonEntity>): PokemonRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { data ->
            database.remoteKeysDao().get(data.name)
        }
    }
    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PokemonEntity>): PokemonRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.name?.let { name ->
                database.remoteKeysDao().get(name)
            }
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>
    ): MediatorResult {
        val offset = when (loadType) {
            LoadType.REFRESH ->{
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextOffset?.minus(REQUEST_LIMIT) ?: INITIAL_OFFSET
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevOffset
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextOffset
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                nextKey
            }
        }

        try {
            val request = GetPokemonListRequest(
                offset = offset,
                limit = state.config.pageSize
            )
            val responseData = client.getPokemonList(request)
            val endOfPaginationReached = responseData.results?.isEmpty() ?: true

            val pokemonEntities = mutableListOf<PokemonEntity>()
            val remoteKeys = mutableListOf<PokemonRemoteKeys>()

            responseData.results?.forEach { result ->
                val nameRequest = GetPokemonByNameRequest(name = result?.name ?: "")

                val pokemonDetail = client.getPokemonDetailByName(nameRequest)
                val pokemonSpecies = client.getPokemonSpeciesByName(nameRequest)

                val primaryTypeName = pokemonDetail.types
                    ?.find { it?.slot == 1 }
                    ?.type
                    ?.name
                    ?.uppercase()

                val secondaryTypeName = pokemonDetail.types
                    ?.find { it?.slot == 2 }
                    ?.type
                    ?.name
                    ?.uppercase()

                val pokemonEntity = PokemonEntity(
                    id = pokemonDetail.id ?: 0,
                    name = pokemonDetail.name.orEmpty(),
                    imageUrl = pokemonDetail.sprites?.other?.officialArtwork?.frontDefault ?: "",
                    primaryType = primaryTypeName?.let { Types.valueOf(it) } ?: Types.UNKNOWN,
                    secondaryType = secondaryTypeName?.let { name ->
                        runCatching { Types.valueOf(name) }.getOrNull()
                    },
                    description = pokemonSpecies.flavorTextEntries?.find {
                        it?.version?.name == "firered" && it.language?.name == "en"
                    }?.flavorText.orEmpty(),
                    isFavorite = false
                )
                pokemonEntities.add(pokemonEntity)

                remoteKeys.add(
                    PokemonRemoteKeys(
                        name = result?.name.orEmpty(),
                        offset = offset,
                        prevOffset = if (offset == INITIAL_OFFSET) null else offset - state.config.pageSize,
                        nextOffset = if (endOfPaginationReached) null else offset + state.config.pageSize
                    )
                )
            }

            database.withTransaction {
                database.pokemonDao().insertAll(pokemonEntities)
                database.remoteKeysDao().insertAll(remoteKeys)
            }

            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }
    }
}