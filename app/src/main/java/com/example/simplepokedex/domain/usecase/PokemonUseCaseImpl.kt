package com.example.simplepokedex.domain.usecase

import androidx.paging.PagingData
import com.example.simplepokedex.data.PokemonRepository
import com.example.simplepokedex.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.flow.Flow

class PokemonUseCaseImpl(
    private val repository: PokemonRepository
) : PokemonUseCase {

    override fun getAllPokemon() = repository.getAllPokemon()

    override fun getPokemonById(id: Int): Flow<Result<Pokemon, Error>> = repository.getPokemonById(id)

    override fun searchPokemon(query: String): Flow<PagingData<Pokemon>> = repository.searchPokemon(query)
}