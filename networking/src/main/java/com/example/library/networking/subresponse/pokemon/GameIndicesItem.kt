package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GameIndicesItem(

	@SerialName("game_index")
	val gameIndex: Int? = null,

	@SerialName("version")
	val version: Version? = null
)