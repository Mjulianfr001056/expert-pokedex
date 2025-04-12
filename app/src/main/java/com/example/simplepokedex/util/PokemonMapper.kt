package com.example.simplepokedex.util

import com.example.library.persistent.entity.PokemonEntity
import com.example.simplepokedex.domain.model.Pokemon

object PokemonMapper {
    fun toDomain(pokemonEntity: PokemonEntity): Pokemon {
        return Pokemon(
            id = pokemonEntity.id,
            name = pokemonEntity.name,
            imageUrl = pokemonEntity.imageUrl,
            description = pokemonEntity.description,
            primaryType = pokemonEntity.primaryType,
            secondaryType = pokemonEntity.secondaryType,
            weaknesses = emptyList(),
            height = "",
            weight = "",
            category = "",
            abilities = "",
            abilitiesDescription = "",
            isFavorite = true
        )
    }

    fun toEntity(pokemon: Pokemon): PokemonEntity {
        return PokemonEntity(
            id = pokemon.id,
            name = pokemon.name,
            imageUrl = pokemon.imageUrl,
            primaryType = pokemon.primaryType,
            secondaryType = pokemon.secondaryType,
            description = pokemon.description
        )
    }
}