package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class OfficialArtwork(

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)