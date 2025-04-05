package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GenerationIv(

    @SerialName("platinum")
	val platinum: Platinum? = null,

    @SerialName("diamond-pearl")
	val diamondPearl: DiamondPearl? = null,

    @SerialName("heartgold-soulsilver")
	val heartgoldSoulsilver: HeartgoldSoulsilver? = null
)