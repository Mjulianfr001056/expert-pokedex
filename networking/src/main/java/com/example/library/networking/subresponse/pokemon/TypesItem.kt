package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class TypesItem(

	@SerialName("slot")
	val slot: Int? = null,

	@SerialName("type")
	val type: Type? = null
)