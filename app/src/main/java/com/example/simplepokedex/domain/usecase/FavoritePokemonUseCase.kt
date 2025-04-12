package com.example.simplepokedex.domain.usecase

import com.example.library.core.domain.model.Pokemon
import id.ac.stis.sipadu.config.Error
import id.ac.stis.sipadu.config.Result
import kotlinx.coroutines.flow.Flow

interface FavoritePokemonUseCase {
    suspend fun savePokemon(pokemon: com.example.library.core.domain.model.Pokemon): Result<Unit, Error>
    suspend fun deletePokemon(pokemon: com.example.library.core.domain.model.Pokemon): Result<Unit, Error>
    suspend fun isFavoritePokemon(id: Int): Flow<Result<Boolean, Error>>
    fun getAllFavoritePokemon(): Flow<Result<List<Pokemon>, Error>>
}