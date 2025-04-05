package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class RubySapphire(

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)