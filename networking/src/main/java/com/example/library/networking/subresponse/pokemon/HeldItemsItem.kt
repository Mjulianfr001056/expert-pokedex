package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class HeldItemsItem(

	@SerialName("item")
	val item: Item? = null,

	@SerialName("version_details")
	val versionDetails: List<VersionDetailsItem?>? = null
)