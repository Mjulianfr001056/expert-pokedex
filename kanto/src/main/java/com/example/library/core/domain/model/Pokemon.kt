package com.example.library.core.domain.model

data class Pokemon (
    val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String,
    val primaryType: id.ac.stis.sipadu.config.Types,
    val secondaryType: id.ac.stis.sipadu.config.Types?,
    val weaknesses: List<id.ac.stis.sipadu.config.Types>,
    val height: String,
    val weight: String,
    val category: String,
    val abilities: String,
    val abilitiesDescription: String,
    val isFavorite: Boolean
)