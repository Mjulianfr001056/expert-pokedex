//package com.example.library.core.domain.mapper
//
//import com.example.library.core.domain.model.Pokemon
//import com.example.library.core.domain.model.Types
//import com.example.library.networking.client.pokemon.response.GetPokemonDetailResponse
//import com.example.library.persistent.entity.PokemonEntity
//
//interface PokemonMapper {
//    fun toModel(input: PokemonEntity): Pokemon
//    fun toEntity(input: GetPokemonDetailResponse): PokemonEntity
//}
//
//internal class PokemonMapperImpl : PokemonMapper {
//    override fun toModel(input: PokemonEntity): Pokemon {
//        return Pokemon(
//            id = input.id,
//            name = input.name,
//            imageUrl = input.imageUrl,
//            description = input.description,
//            primaryType = input.primaryType,
//            secondaryType = input.secondaryType,
//            weaknesses = emptyList(),
//            height = "",
//            weight = "",
//            category = "",
//            abilities = "",
//            abilitiesDescription = "",
//            isFavorite = input.isFavorite
//        )
//    }
//
//    override fun toEntity(input: GetPokemonDetailResponse): PokemonEntity {
//        return PokemonEntity(
//            id = input.id ?: 0,
//            name = input.name.orEmpty(),
//            imageUrl = input.sprites?.other?.officialArtwork?.frontDefault ?: "",
//            primaryType = input.types?.find { it?.slot == 1 }?.type?.name?.uppercase().let {
//                Types.valueOf(it ?: "UNKNOWN")
//            },
//            secondaryType = input.types?.find { it?.slot == 2 }?.type?.name?.uppercase().let {
//                Types.valueOf(it ?: "UNKNOWN")
//            },
//            description = input.,
//            isFavorite = false
//        )
//    }
//}