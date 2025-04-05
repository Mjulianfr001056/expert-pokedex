package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GenerationV(

	@SerialName("black-white")
	val blackWhite: BlackWhite? = null
)