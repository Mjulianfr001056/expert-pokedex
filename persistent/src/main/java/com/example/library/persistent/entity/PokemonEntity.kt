package com.example.library.persistent.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.library.persistent.converter.Types

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "primary_type")
    val primaryType: Types,

    @ColumnInfo(name = "secondary_type")
    val secondaryType: Types?,

    @ColumnInfo(name = "weaknesses")
    val weaknesses: List<Types>,

    @ColumnInfo(name = "height")
    val height: String,

    @ColumnInfo(name = "weight")
    val weight: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "abilities")
    val abilities: String,

    @ColumnInfo(name = "abilities_description")
    val abilitiesDescription: String,
)
