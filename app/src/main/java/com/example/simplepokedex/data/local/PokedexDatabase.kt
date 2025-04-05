package com.example.simplepokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(TypesConverter::class)
abstract class PokedexDatabase : RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao
}