package com.example.library.persistent.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.library.core.domain.model.Types

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imageUrl: String,
    val primaryType: Types,
    val secondaryType: Types?,
    val description: String,
)