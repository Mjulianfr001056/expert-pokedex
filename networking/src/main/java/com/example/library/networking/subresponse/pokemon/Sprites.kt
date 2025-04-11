package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Sprites(

    @SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

    @SerialName("back_female")
	val backFemale: String? = null,

    @SerialName("other")
	val other: Other? = null,

    @SerialName("back_default")
	val backDefault: String? = null,

    @SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

    @SerialName("front_default")
	val frontDefault: String? = null,

    @SerialName("versions")
	val versions: Versions? = null,

    @SerialName("front_female")
	val frontFemale: String? = null,

    @SerialName("back_shiny")
	val backShiny: String? = null,

    @SerialName("front_shiny")
	val frontShiny: String? = null
)