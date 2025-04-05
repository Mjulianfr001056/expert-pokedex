package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Yellow(

	@SerialName("front_gray")
	val frontGray: String? = null,

	@SerialName("back_transparent")
	val backTransparent: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("back_gray")
	val backGray: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null
)