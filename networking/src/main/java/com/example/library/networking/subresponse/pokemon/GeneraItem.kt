package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GeneraItem(

	@SerialName("genus")
	val genus: String? = null,

	@SerialName("language")
	val language: Language? = null
)