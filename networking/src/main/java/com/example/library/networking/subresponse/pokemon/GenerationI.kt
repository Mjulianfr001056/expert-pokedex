package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GenerationI(

    @SerialName("yellow")
	val yellow: Yellow? = null,

    @SerialName("red-blue")
	val redBlue: RedBlue? = null
)