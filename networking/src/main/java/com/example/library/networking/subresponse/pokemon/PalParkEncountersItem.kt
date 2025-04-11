package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PalParkEncountersItem(

    @SerialName("area")
	val area: Area? = null,

    @SerialName("base_score")
	val baseScore: Int? = null,

    @SerialName("rate")
	val rate: Int? = null
)