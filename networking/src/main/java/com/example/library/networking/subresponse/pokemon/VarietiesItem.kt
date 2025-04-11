package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class VarietiesItem(

    @SerialName("pokemon")
	val pokemon: Pokemon? = null,

    @SerialName("is_default")
	val isDefault: Boolean? = null
)