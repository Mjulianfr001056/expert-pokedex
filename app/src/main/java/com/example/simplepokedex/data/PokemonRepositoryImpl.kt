package com.example.simplepokedex.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.simplepokedex.domain.model.Pokemon
import com.example.library.networking.client.pokemon.PokemonClient
import com.example.library.persistent.PokedexDatabase
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.GeneralError
import com.example.simplepokedex.util.PokemonMapper
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PokemonRepositoryImpl(
    private val database: PokedexDatabase,
    private val client: PokemonClient,
) : PokemonRepository {
    private val dao = database.pokemonDao()

    override fun getAllPokemon(): Flow<PagingData<Pokemon>> {
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                prefetchDistance = 3,
                enablePlaceholders = true,
            ),
            remoteMediator = PokemonRemoteMediator(
                database = database,
                client = client,
            ),
            pagingSourceFactory = {
                dao.getAll()
            }
        ).flow.map { pagingData ->
            pagingData.map { entity -> PokemonMapper.toDomain(entity) }
        }.flowOn(Dispatchers.IO)
    }

    override fun getPokemonById(id: Int): Flow<Result<Pokemon, Error>> {
        return emptyFlow()
    }

    override suspend fun savePokemon(pokemon: Pokemon): Result<Unit, Error> {
        return try {
            dao.insert(PokemonMapper.toEntity(pokemon))
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(GeneralError.IO_ERROR)
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun searchPokemon(query: String): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                prefetchDistance = 3,
                enablePlaceholders = true,
            ),
            remoteMediator = PokemonRemoteMediator(
                database = database,
                client = client,
            ),
            pagingSourceFactory = {
                dao.search(query)
            }
        ).flow.map { pagingData ->
            pagingData.map { entity -> PokemonMapper.toDomain(entity) }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun deletePokemon(pokemon: Pokemon): Result<Unit, Error> {
        return try {
            dao.delete(PokemonMapper.toEntity(pokemon))
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(GeneralError.IO_ERROR)
        }
    }

    override suspend fun isFavoritePokemon(id: Int): Flow<Result<Boolean, Error>> {
        return dao.getById(id).map {
            Result.Success(it != null)
        }
    }

    override fun getAllFavoritePokemon(): Flow<Result<List<Pokemon>, Error>> {
        return dao.getAll2().map {
            Result.Success(it.map { PokemonMapper.toDomain(it) })
        }
    }
}