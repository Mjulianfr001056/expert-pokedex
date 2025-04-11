package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class VersionGroupDetailsItem(

    @SerialName("level_learned_at")
	val levelLearnedAt: Int? = null,

    @SerialName("version_group")
	val versionGroup: VersionGroup? = null,

    @SerialName("move_learn_method")
	val moveLearnMethod: MoveLearnMethod? = null,

    @SerialName("order")
	val order: Int? = null
)