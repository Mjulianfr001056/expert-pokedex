package com.example.library.persistent.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.library.persistent.entity.PokemonRemoteKeys

@Dao
interface PokemonRemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<PokemonRemoteKeys>)

    @Query("SELECT * FROM pokemon_remote_keys WHERE name = :name")
    suspend fun get(name: String): PokemonRemoteKeys?

    @Query("DELETE FROM pokemon_remote_keys")
    suspend fun deleteAll()
}