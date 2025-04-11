package com.example.library.networking.subresponse.pokemon

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PokedexNumbersItem(

	@SerialName("entry_number")
	val entryNumber: Int? = null,

	@SerialName("pokedex")
	val pokedex: Pokedex? = null
)