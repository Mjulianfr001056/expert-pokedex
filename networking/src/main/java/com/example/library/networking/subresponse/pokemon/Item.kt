package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Item(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)