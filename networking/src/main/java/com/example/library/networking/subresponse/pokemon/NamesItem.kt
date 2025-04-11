package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class NamesItem(

	@SerialName("name")
	val name: String? = null,

	@SerialName("language")
	val language: Language? = null
)