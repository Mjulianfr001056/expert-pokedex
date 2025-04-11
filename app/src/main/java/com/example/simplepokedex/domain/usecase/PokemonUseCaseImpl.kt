package com.example.simplepokedex.domain.usecase

import com.example.simplepokedex.data.PokemonRepository
import com.example.library.core.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.flow.Flow

class PokemonUseCaseImpl(
    private val repository: PokemonRepository
) : PokemonUseCase {

    override fun getAllPokemon() = repository.getAllPokemon()

    override fun getPokemonById(id: Int): Flow<Result<Pokemon, Error>> = repository.getPokemonById(id)

    override fun searchPokemon(query: String): Flow<Result<List<Pokemon>, Error>> = repository.searchPokemon(query)
}