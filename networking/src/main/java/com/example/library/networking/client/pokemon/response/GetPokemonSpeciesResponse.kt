package com.example.library.networking.client.pokemon.response

import com.example.library.networking.subresponse.pokemon.Color
import com.example.library.networking.subresponse.pokemon.EggGroupsItem
import com.example.library.networking.subresponse.pokemon.EvolutionChain
import com.example.library.networking.subresponse.pokemon.FlavorTextEntriesItem
import com.example.library.networking.subresponse.pokemon.GeneraItem
import com.example.library.networking.subresponse.pokemon.Generation
import com.example.library.networking.subresponse.pokemon.GrowthRate
import com.example.library.networking.subresponse.pokemon.Habitat
import com.example.library.networking.subresponse.pokemon.NamesItem
import com.example.library.networking.subresponse.pokemon.PalParkEncountersItem
import com.example.library.networking.subresponse.pokemon.PokedexNumbersItem
import com.example.library.networking.subresponse.pokemon.ResultsItem
import com.example.library.networking.subresponse.pokemon.Shape
import com.example.library.networking.subresponse.pokemon.VarietiesItem
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetPokemonSpeciesResponse(

    @SerialName("evolution_chain")
	val evolutionChain: EvolutionChain? = null,

    @SerialName("genera")
	val genera: List<GeneraItem?>? = null,

    @SerialName("habitat")
	val habitat: Habitat? = null,

    @SerialName("color")
	val color: Color? = null,

    @SerialName("egg_groups")
	val eggGroups: List<EggGroupsItem?>? = null,

    @SerialName("capture_rate")
	val captureRate: Int? = null,

    @SerialName("pokedex_numbers")
	val pokedexNumbers: List<PokedexNumbersItem?>? = null,

    @SerialName("forms_switchable")
	val formsSwitchable: Boolean? = null,

    @SerialName("growth_rate")
	val growthRate: GrowthRate? = null,

    @SerialName("flavor_text_entries")
	val flavorTextEntries: List<FlavorTextEntriesItem?>? = null,

    @SerialName("id")
	val id: Int? = null,

    @SerialName("is_baby")
	val isBaby: Boolean? = null,

    @SerialName("order")
	val order: Int? = null,

    @SerialName("generation")
	val generation: Generation? = null,

    @SerialName("is_legendary")
	val isLegendary: Boolean? = null,

    @SerialName("pal_park_encounters")
	val palParkEncounters: List<PalParkEncountersItem?>? = null,

    @SerialName("shape")
	val shape: Shape? = null,

    @SerialName("is_mythical")
	val isMythical: Boolean? = null,

    @SerialName("base_happiness")
	val baseHappiness: Int? = null,

    @SerialName("names")
	val names: List<NamesItem?>? = null,

    @SerialName("varieties")
	val varieties: List<VarietiesItem?>? = null,

    @SerialName("gender_rate")
	val genderRate: Int? = null,

    @SerialName("name")
	val name: String? = null,

    @SerialName("has_gender_differences")
	val hasGenderDifferences: Boolean? = null,

    @SerialName("hatch_counter")
	val hatchCounter: Int? = null,

    @SerialName("form_descriptions")
	val formDescriptions: List<String?>? = null,

    @SerialName("evolves_from_species")
	val evolvesFromSpecies: ResultsItem? = null
)