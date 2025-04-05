package com.example.simplepokedex.domain.usecase

import com.example.library.core.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.flow.Flow

interface FavoritePokemonUseCase {
    suspend fun savePokemon(pokemon: com.example.library.core.domain.model.Pokemon): Result<Unit, Error>
    suspend fun deletePokemon(pokemon: com.example.library.core.domain.model.Pokemon): Result<Unit, Error>
    suspend fun isFavoritePokemon(id: Int): Flow<Result<Boolean, Error>>
    fun getAllFavoritePokemon(): Flow<Result<List<com.example.library.core.domain.model.Pokemon>, Error>>
}