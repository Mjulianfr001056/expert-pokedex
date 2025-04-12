package com.example.simplepokedex.domain.usecase

import androidx.paging.PagingData
import com.example.library.core.domain.data.PokemonRepository
import com.example.library.core.domain.model.Pokemon
import id.ac.stis.sipadu.config.Error
import id.ac.stis.sipadu.config.Result
import kotlinx.coroutines.flow.Flow

class PokemonUseCaseImpl(
    private val repository: PokemonRepository
) : PokemonUseCase {

    override fun getAllPokemon() = repository.getAllPokemon()

    override fun getPokemonById(id: Int): Flow<Result<Pokemon, Error>> = repository.getPokemonById(id)

    override fun searchPokemon(query: String): Flow<PagingData<Pokemon>> = repository.searchPokemon(query)
}