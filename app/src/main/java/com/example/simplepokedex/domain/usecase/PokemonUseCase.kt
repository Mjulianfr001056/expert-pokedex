package com.example.simplepokedex.domain.usecase

import androidx.paging.PagingData
import com.example.simplepokedex.domain.model.Pokemon
import com.example.library.core.Error
import com.example.library.core.Result
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun getAllPokemon() : Flow<PagingData<Pokemon>>
    fun getPokemonById(id: Int) : Flow<Result<Pokemon, Error>>
    fun searchPokemon(query: String) : Flow<PagingData<Pokemon>>
}