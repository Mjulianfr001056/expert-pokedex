package com.example.library.core.domain.data

import androidx.paging.PagingData
import com.example.library.core.domain.model.Pokemon
import id.ac.stis.sipadu.config.Error
import id.ac.stis.sipadu.config.Result
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getAllPokemon() : Flow<PagingData<Pokemon>>
    fun getPokemonById(id: Int) : Flow<Result<Pokemon, Error>>
    fun searchPokemon(query: String) : Flow<PagingData<Pokemon>>

    suspend fun savePokemon(pokemon: Pokemon): Result<Unit, Error>
    suspend fun deletePokemon(pokemon: Pokemon): Result<Unit, Error>
    suspend fun isFavoritePokemon(id: Int): Flow<Result<Boolean, Error>>
    fun getAllFavoritePokemon() : Flow<Result<List<Pokemon>, Error>>
}