package com.example.simplepokedex.domain.usecase

import com.example.simplepokedex.data.PokemonRepository
import com.example.simplepokedex.domain.model.Pokemon
import com.example.simplepokedex.util.Error
import com.example.simplepokedex.util.Result
import kotlinx.coroutines.flow.Flow

class FavoritePokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : FavoritePokemonUseCase {
    override suspend fun savePokemon(pokemon: Pokemon) = pokemonRepository.savePokemon(pokemon)

    override suspend fun deletePokemon(pokemon: Pokemon) = pokemonRepository.deletePokemon(pokemon)

    override suspend fun isFavoritePokemon(id: Int) = pokemonRepository.isFavoritePokemon(id)

    override fun getAllFavoritePokemon(): Flow<Result<List<Pokemon>, Error>> = pokemonRepository.getAllFavoritePokemon()
}