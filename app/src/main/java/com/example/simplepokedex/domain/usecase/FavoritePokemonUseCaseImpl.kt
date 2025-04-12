package com.example.simplepokedex.domain.usecase

import com.example.library.core.domain.data.PokemonRepository
import com.example.library.core.domain.model.Pokemon
import id.ac.stis.sipadu.config.Error
import id.ac.stis.sipadu.config.Result
import kotlinx.coroutines.flow.Flow

class FavoritePokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : FavoritePokemonUseCase {
    override suspend fun savePokemon(pokemon: com.example.library.core.domain.model.Pokemon) = pokemonRepository.savePokemon(pokemon)

    override suspend fun deletePokemon(pokemon: com.example.library.core.domain.model.Pokemon) = pokemonRepository.deletePokemon(pokemon)

    override suspend fun isFavoritePokemon(id: Int) = pokemonRepository.isFavoritePokemon(id)

    override fun getAllFavoritePokemon(): Flow<Result<List<Pokemon>, Error>> = pokemonRepository.getAllFavoritePokemon()
}