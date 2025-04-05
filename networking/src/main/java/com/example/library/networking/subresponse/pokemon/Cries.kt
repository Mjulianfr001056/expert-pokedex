package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Cries(

	@SerialName("legacy")
	val legacy: String? = null,

	@SerialName("latest")
	val latest: String? = null
)