package com.example.library.persistent.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.library.persistent.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Upsert
    suspend fun insert(pokemon: PokemonEntity)

    @Upsert
    suspend fun insertAll(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon WHERE name LIKE '%' || :query || '%' ORDER BY id ASC")
    fun search(query: String): PagingSource<Int, PokemonEntity>

    @Query("SELECT * FROM pokemon")
    fun getAll(): PagingSource<Int, PokemonEntity>

    @Query("SELECT * FROM pokemon")
    fun getAll2(): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: Int): Flow<PokemonEntity?>

    @Delete
    suspend fun delete(pokemon: PokemonEntity)

    @Query("DELETE FROM pokemon")
    suspend fun deleteAll()
}