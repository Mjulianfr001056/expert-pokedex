package com.example.library.persistent

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.library.persistent.converter.TypesConverter
import com.example.library.persistent.dao.FavoriteDao
import com.example.library.persistent.dao.PokemonDao
import com.example.library.persistent.dao.PokemonRemoteKeysDao
import com.example.library.persistent.entity.FavoritePokemon
import com.example.library.persistent.entity.PokemonEntity
import com.example.library.persistent.entity.PokemonRemoteKeys

@Database(
    entities = [
        FavoritePokemon::class,
        PokemonEntity::class,
        PokemonRemoteKeys::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypesConverter::class)
abstract class PokedexDatabase : RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao
    abstract fun remoteKeysDao(): PokemonRemoteKeysDao
    abstract fun favoriteDao(): FavoriteDao
}