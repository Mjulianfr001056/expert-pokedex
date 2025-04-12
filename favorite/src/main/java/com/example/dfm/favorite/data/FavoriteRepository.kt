package com.example.dfm.favorite.data

import com.example.dfm.favorite.domain.model.Favorite
import com.example.library.persistent.dao.FavoriteDao
import com.example.library.persistent.entity.FavoritePokemon
import com.example.library.core.Result
import com.example.library.core.Error
import com.example.library.core.util.GeneralError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface FavoriteRepository {
    suspend fun addFavorite(id: Int): Result<Unit, Error>
    suspend fun removeFavorite(id: Int): Result<Unit, Error>
    suspend fun isFavorite(id: Int): Flow<Result<Boolean, Error>>
    fun getAll() : Flow<Result<List<Favorite>, Error>>
}

internal class FavoriteRepositoryImpl(
    private val dao: FavoriteDao,
) : FavoriteRepository {
    override suspend fun addFavorite(id: Int): Result<Unit, Error> {
        val entity = FavoritePokemon(id)

        return try {
            dao.insert(entity)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(GeneralError.IO_ERROR)
        }
    }

    override suspend fun removeFavorite(id: Int): Result<Unit, Error> {
        val entity = FavoritePokemon(id)

        return try {
            dao.delete(entity)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(GeneralError.IO_ERROR)
        }
    }

    override suspend fun isFavorite(id: Int): Flow<Result<Boolean, Error>> {
        return dao.get(id).map {
            Result.Success(it != null)
        }
    }

    override fun getAll(): Flow<Result<List<Favorite>, Error>> {
        return dao.getAll().map { list ->
            Result.Success(list.map { Favorite(it.id) })
        }
    }
}