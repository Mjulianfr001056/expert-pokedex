package com.example.simplepokedex.domain.usecase

import androidx.paging.PagingData
import com.example.library.core.domain.model.Pokemon
import id.ac.stis.sipadu.config.Error
import id.ac.stis.sipadu.config.Result
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun getAllPokemon() : Flow<PagingData<Pokemon>>
    fun getPokemonById(id: Int) : Flow<Result<Pokemon, Error>>
    fun searchPokemon(query: String) : Flow<PagingData<Pokemon>>
}