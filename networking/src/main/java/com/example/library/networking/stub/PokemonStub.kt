package com.example.library.networking.stub

data class PokemonStub(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val primaryType: com.example.library.core.domain.model.Types,
    val secondaryType: com.example.library.core.domain.model.Types?,
    val weaknesses: List<com.example.library.core.domain.model.Types>,
    val height: String,
    val weight: String,
    val category: String,
    val abilities: String,
    val abilitiesDescription: String,
)