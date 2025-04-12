package com.example.simplepokedex.util

import com.example.library.persistent.entity.PokemonEntity
import com.example.library.networking.stub.PokemonStub

object PokemonMapper {
    fun toDomain(pokemonStub: PokemonStub): com.example.library.core.domain.model.Pokemon {
        return com.example.library.core.domain.model.Pokemon(
            id = pokemonStub.id,
            name = pokemonStub.name,
            imageUrl = pokemonStub.imageUrl,
            description = pokemonStub.description,
            primaryType = pokemonStub.primaryType,
            secondaryType = pokemonStub.secondaryType,
            weaknesses = pokemonStub.weaknesses,
            height = pokemonStub.height,
            weight = pokemonStub.weight,
            category = pokemonStub.category,
            abilities = pokemonStub.abilities,
            abilitiesDescription = pokemonStub.abilitiesDescription,
            isFavorite = false
        )
    }

    fun toDomain(pokemonEntity: PokemonEntity): com.example.library.core.domain.model.Pokemon {
        return com.example.library.core.domain.model.Pokemon(
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

    fun toEntity(pokemon: com.example.library.core.domain.model.Pokemon): PokemonEntity {
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