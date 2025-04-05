package com.example.library.networking.client.pokemon.response

import com.example.library.networking.subresponse.pokemon.ResultsItem
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetPokemonListResponse(

	@SerialName("next")
	val next: String? = null,

	@SerialName("previous")
	val previous: String? = null,

	@SerialName("count")
	val count: Int? = null,

	@SerialName("results")
	val results: List<ResultsItem?>? = null
)