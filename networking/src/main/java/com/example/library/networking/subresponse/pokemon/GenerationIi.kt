package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GenerationIi(

    @SerialName("gold")
	val gold: Gold? = null,

    @SerialName("crystal")
	val crystal: Crystal? = null,

    @SerialName("silver")
	val silver: Silver? = null
)