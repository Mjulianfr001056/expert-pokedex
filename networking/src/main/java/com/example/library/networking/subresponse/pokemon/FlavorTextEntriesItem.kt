package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class FlavorTextEntriesItem(

    @SerialName("language")
	val language: Language? = null,

    @SerialName("version")
	val version: Version? = null,

    @SerialName("flavor_text")
	val flavorText: String? = null
)