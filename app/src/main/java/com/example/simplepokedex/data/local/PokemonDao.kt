package com.example.simplepokedex.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Upsert
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon")
    fun getAll(): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: Int): Flow<PokemonEntity?>

    @Delete
    suspend fun delete(pokemon: PokemonEntity)
}