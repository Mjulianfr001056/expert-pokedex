package com.example.library.networking.client.pokemon.response

import com.example.library.networking.subresponse.pokemon.AbilitiesItem
import com.example.library.networking.subresponse.pokemon.Cries
import com.example.library.networking.subresponse.pokemon.FormsItem
import com.example.library.networking.subresponse.pokemon.GameIndicesItem
import com.example.library.networking.subresponse.pokemon.HeldItemsItem
import com.example.library.networking.subresponse.pokemon.MovesItem
import com.example.library.networking.subresponse.pokemon.PastTypesItem
import com.example.library.networking.subresponse.pokemon.Species
import com.example.library.networking.subresponse.pokemon.Sprites
import com.example.library.networking.subresponse.pokemon.StatsItem
import com.example.library.networking.subresponse.pokemon.TypesItem
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetPokemonDetailResponse(

    @SerialName("abilities")
	val abilities: List<AbilitiesItem?>? = null,

    @SerialName("base_experience")
	val baseExperience: Int? = null,

    @SerialName("cries")
	val cries: Cries? = null,

    @SerialName("forms")
	val forms: List<FormsItem?>? = null,

    @SerialName("game_indices")
	val gameIndices: List<GameIndicesItem?>? = null,

    @SerialName("height")
	val height: Int? = null,

    @SerialName("held_items")
	val heldItems: List<HeldItemsItem?>? = null,

    @SerialName("id")
	val id: Int? = null,

    @SerialName("is_default")
	val isDefault: Boolean? = null,

    @SerialName("location_area_encounters")
	val locationAreaEncounters: String? = null,

    @SerialName("moves")
	val moves: List<MovesItem?>? = null,

    @SerialName("name")
	val name: String? = null,

    @SerialName("order")
	val order: Int? = null,

    @SerialName("past_abilities")
	val pastAbilities: List<AbilitiesItem?>? = null,

    @SerialName("past_types")
	val pastTypes: List<PastTypesItem?>? = null,

    @SerialName("species")
	val species: Species? = null,

    @SerialName("sprites")
	val sprites: Sprites? = null,

    @SerialName("stats")
	val stats: List<StatsItem?>? = null,

    @SerialName("types")
	val types: List<TypesItem?>? = null,

    @SerialName("weight")
	val weight: Int? = null
)
