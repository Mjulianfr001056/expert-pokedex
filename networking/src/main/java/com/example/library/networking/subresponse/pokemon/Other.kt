package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Other(

    @SerialName("dream_world")
	val dreamWorld: DreamWorld? = null,

    @SerialName("showdown")
	val showdown: Showdown? = null,

    @SerialName("official-artwork")
	val officialArtwork: OfficialArtwork? = null,

    @SerialName("home")
	val home: Home? = null
)