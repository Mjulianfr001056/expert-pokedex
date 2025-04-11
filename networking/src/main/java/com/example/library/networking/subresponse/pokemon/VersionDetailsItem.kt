package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class VersionDetailsItem(

	@SerialName("version")
	val version: Version? = null,

	@SerialName("rarity")
	val rarity: Int? = null
)