package com.example.library.persistent.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.library.persistent.entity.FavoritePokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Upsert
    suspend fun insert(pokemon: FavoritePokemon)

    @Query("SELECT * FROM favorite_pokemon WHERE id = :id")
    fun get(id: Int): Flow<FavoritePokemon?>

    @Query("SELECT * FROM favorite_pokemon")
    fun getAll(): Flow<List<FavoritePokemon>>

    @Delete
    suspend fun delete(pokemon: FavoritePokemon)
}