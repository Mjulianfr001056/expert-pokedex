package com.example.dfm.favorite.domain.usecase

import com.example.dfm.favorite.data.FavoriteRepository
import com.example.dfm.favorite.domain.model.Favorite
import com.example.library.core.Result
import com.example.library.core.Error

import kotlinx.coroutines.flow.Flow

interface FavoritePokemonUseCase {
    suspend fun savePokemon(id: Int): Result<Unit, Error>
    suspend fun deletePokemon(id: Int): Result<Unit, Error>
    suspend fun isFavoritePokemon(id: Int): Flow<Result<Boolean, Error>>
    fun getAllFavoritePokemon(): Flow<Result<List<Favorite>, Error>>
}

internal class FavoritePokemonUseCaseImpl(
    private val repository: FavoriteRepository
) : FavoritePokemonUseCase {
    override suspend fun savePokemon(id: Int) = repository.addFavorite(id)

    override suspend fun deletePokemon(id: Int) = repository.removeFavorite(id)

    override suspend fun isFavoritePokemon(id: Int) = repository.isFavorite(id)

    override fun getAllFavoritePokemon(): Flow<Result<List<Favorite>, Error>> = repository.getAll()
}