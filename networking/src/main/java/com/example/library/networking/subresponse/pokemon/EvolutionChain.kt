package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class EvolutionChain(

	@SerialName("url")
	val url: String? = null
)