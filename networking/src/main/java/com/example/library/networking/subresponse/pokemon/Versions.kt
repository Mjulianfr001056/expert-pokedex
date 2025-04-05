package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Versions(

    @SerialName("generation-iii")
	val generationIii: GenerationIii? = null,

    @SerialName("generation-ii")
	val generationIi: GenerationIi? = null,

    @SerialName("generation-v")
	val generationV: GenerationV? = null,

    @SerialName("generation-iv")
	val generationIv: GenerationIv? = null,

    @SerialName("generation-vii")
	val generationVii: GenerationVii? = null,

    @SerialName("generation-i")
	val generationI: GenerationI? = null,

    @SerialName("generation-viii")
	val generationViii: GenerationViii? = null,

    @SerialName("generation-vi")
	val generationVi: GenerationVi? = null
)