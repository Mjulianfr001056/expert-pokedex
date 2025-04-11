package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PastTypesItem(

	@SerialName("generation")
	val generation: Generation? = null,

	@SerialName("types")
	val types: List<TypesItem?>? = null
)