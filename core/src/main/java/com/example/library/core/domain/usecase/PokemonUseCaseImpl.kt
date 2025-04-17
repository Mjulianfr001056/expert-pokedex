package com.example.library.core.domain.usecase

import androidx.paging.PagingData
import com.example.library.core.Error
import com.example.library.core.Result
import com.example.library.core.data.PokemonRepository
import com.example.library.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

class PokemonUseCaseImpl(
    private val repository: PokemonRepository,
) : PokemonUseCase {

    override fun getAllPokemon() = repository.getAllPokemon()

    override fun getLocalPokemon(): Flow<PagingData<Pokemon>> = repository.getLocalPokemon()

    override fun getPokemonById(id: Int): Flow<Result<Pokemon, Error>> = repository.getPokemonById(id)

    override fun searchPokemon(query: String): Flow<PagingData<Pokemon>> = repository.searchPokemon(query)
}