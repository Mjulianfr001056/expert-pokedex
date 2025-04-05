package com.example.simplepokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simplepokedex.data.stub.Types

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