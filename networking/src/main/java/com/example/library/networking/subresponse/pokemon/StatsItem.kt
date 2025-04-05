package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class StatsItem(

    @SerialName("stat")
	val stat: Stat? = null,

    @SerialName("base_stat")
	val baseStat: Int? = null,

    @SerialName("effort")
	val effort: Int? = null
)