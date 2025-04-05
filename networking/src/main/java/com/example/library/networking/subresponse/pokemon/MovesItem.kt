package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class MovesItem(

    @SerialName("version_group_details")
	val versionGroupDetails: List<VersionGroupDetailsItem?>? = null,

    @SerialName("move")
	val move: Move? = null
)