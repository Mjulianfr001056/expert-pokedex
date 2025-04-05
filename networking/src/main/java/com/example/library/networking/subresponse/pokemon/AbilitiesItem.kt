package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class AbilitiesItem(

	@SerialName("is_hidden")
	val isHidden: Boolean? = null,

	@SerialName("ability")
	val ability: Ability? = null,

	@SerialName("slot")
	val slot: Int? = null
)