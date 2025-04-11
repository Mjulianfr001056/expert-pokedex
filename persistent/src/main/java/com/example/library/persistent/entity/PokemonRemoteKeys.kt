package com.example.library.persistent.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_remote_keys")
data class PokemonRemoteKeys(
    @PrimaryKey
    val name: String,
    val offset: Int,
    val prevOffset: Int?,
    val nextOffset: Int?,
)