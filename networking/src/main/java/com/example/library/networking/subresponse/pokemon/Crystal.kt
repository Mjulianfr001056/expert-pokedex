package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Crystal(

	@SerialName("back_transparent")
	val backTransparent: String? = null,

	@SerialName("back_shiny_transparent")
	val backShinyTransparent: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null,

	@SerialName("front_shiny_transparent")
	val frontShinyTransparent: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)