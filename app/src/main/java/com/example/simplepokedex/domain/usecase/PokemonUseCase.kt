package com.example.simplepokedex.domain.usecase

import com.example.library.core.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun getAllPokemon() : Flow<Result<List<com.example.library.core.domain.model.Pokemon>, Error>>
    fun getPokemonById(id: Int) : Flow<Result<com.example.library.core.domain.model.Pokemon, Error>>
    fun searchPokemon(query: String) : Flow<Result<List<com.example.library.core.domain.model.Pokemon>, Error>>
}