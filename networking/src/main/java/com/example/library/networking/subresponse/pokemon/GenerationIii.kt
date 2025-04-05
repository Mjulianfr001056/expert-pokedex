package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GenerationIii(

    @SerialName("firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreen? = null,

    @SerialName("ruby-sapphire")
	val rubySapphire: RubySapphire? = null,

    @SerialName("emerald")
	val emerald: Emerald? = null
)