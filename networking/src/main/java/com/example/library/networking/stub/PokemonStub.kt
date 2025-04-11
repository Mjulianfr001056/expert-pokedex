package com.example.library.networking.stub

import id.ac.stis.sipadu.config.Types

data class PokemonStub(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val primaryType: Types,
    val secondaryType: Types?,
    val weaknesses: List<Types>,
    val height: String,
    val weight: String,
    val category: String,
    val abilities: String,
    val abilitiesDescription: String,
)