package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GenerationViii(

	@SerialName("icons")
	val icons: Icons? = null
)