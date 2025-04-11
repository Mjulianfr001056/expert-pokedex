package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Home(

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)