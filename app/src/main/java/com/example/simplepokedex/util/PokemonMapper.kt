package com.example.simplepokedex.util

import com.example.library.networking.client.pokemon.response.GetPokemonDetailResponse
import com.example.library.networking.client.pokemon.response.GetPokemonSpeciesResponse
import com.example.library.persistent.converter.Types
import com.example.library.persistent.entity.PokemonEntity
import com.example.simplepokedex.domain.model.Pokemon

object PokemonMapper {
    fun toDomain(pokemonEntity: PokemonEntity?): Pokemon {
        val default = Pokemon(
            id = 0,
            name = "",
            imageUrl = "",
            description = "",
            primaryType = Types.UNKNOWN,
            secondaryType = Types.UNKNOWN,
            weaknesses = emptyList(),
            height = "",
            weight = "",
            category = "",
            abilities = "",
            abilitiesDescription = "",
        )

        if (pokemonEntity == null) {
            return default
        }

        return Pokemon(
            id = pokemonEntity.id,
            name = pokemonEntity.name,
            imageUrl = pokemonEntity.imageUrl,
            description = pokemonEntity.description,
            primaryType = pokemonEntity.primaryType,
            secondaryType = pokemonEntity.secondaryType,
            weaknesses = pokemonEntity.weaknesses,
            height = pokemonEntity.height,
            weight = pokemonEntity.weight,
            category = pokemonEntity.category,
            abilities = pokemonEntity.abilities,
            abilitiesDescription = pokemonEntity.abilitiesDescription,
        )
    }

    fun toEntity(
        detailResponse: GetPokemonDetailResponse,
        speciesResponse: GetPokemonSpeciesResponse,
    ): PokemonEntity {

        val primaryTypeName = detailResponse.types
            ?.find { it?.slot == 1 }
            ?.type
            ?.name
            ?.uppercase()

        val secondaryTypeName = detailResponse.types
            ?.find { it?.slot == 2 }
            ?.type
            ?.name
            ?.uppercase()

        return PokemonEntity(
            id = detailResponse.id ?: 0,
            name = detailResponse.name.orEmpty(),
            imageUrl = detailResponse.sprites?.other?.officialArtwork?.frontDefault ?: "",
            primaryType = primaryTypeName?.let { Types.valueOf(it) } ?: Types.UNKNOWN,
            secondaryType = secondaryTypeName?.let { name ->
                runCatching { Types.valueOf(name) }.getOrNull()
            },
            height = detailResponse.height.toString(),
            weight = detailResponse.weight.toString(),
            category = speciesResponse.genera?.find {
                it?.language?.name == "en"
            }?.genus.orEmpty(),
            abilities = detailResponse.abilities?.joinToString(", ") { it?.ability?.name.orEmpty() }.orEmpty(),
            abilitiesDescription = detailResponse.abilities?.joinToString(", ") {
                it?.ability?.name.orEmpty()
            }.orEmpty(),
            weaknesses = detailResponse.types?.mapNotNull { type ->
                type?.type?.name?.uppercase()?.let { name ->
                    runCatching { Types.valueOf(name) }.getOrNull()
                }
            }.orEmpty(),
            description = speciesResponse.flavorTextEntries?.find {
                it?.version?.name == "firered" && it.language?.name == "en"
            }?.flavorText.orEmpty(),
        )
    }
}