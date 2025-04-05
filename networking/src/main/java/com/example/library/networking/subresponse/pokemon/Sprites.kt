package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Sprites(

    @SerialName("back_shiny_female")
	val backShinyFemale: Any? = null,

    @SerialName("back_female")
	val backFemale: Any? = null,

    @SerialName("other")
	val other: Other? = null,

    @SerialName("back_default")
	val backDefault: String? = null,

    @SerialName("front_shiny_female")
	val frontShinyFemale: Any? = null,

    @SerialName("front_default")
	val frontDefault: String? = null,

    @SerialName("versions")
	val versions: Versions? = null,

    @SerialName("front_female")
	val frontFemale: Any? = null,

    @SerialName("back_shiny")
	val backShiny: String? = null,

    @SerialName("front_shiny")
	val frontShiny: String? = null
)