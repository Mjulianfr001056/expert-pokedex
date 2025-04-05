package com.example.simplepokedex.domain.usecase

import com.example.simplepokedex.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun getAllPokemon() : Flow<Result<List<Pokemon>, Error>>
    fun getPokemonById(id: Int) : Flow<Result<Pokemon, Error>>
    fun searchPokemon(query: String) : Flow<Result<List<Pokemon>, Error>>
}