package com.example.library.persistent.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import id.ac.stis.sipadu.config.Types

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imageUrl: String,
    val primaryType: Types,
    val secondaryType: Types?,
    val description: String,
    val isFavorite: Boolean = false,
)