package com.example.library.persistent.di

import androidx.room.Room
import com.example.library.persistent.PokedexDatabase
import org.koin.dsl.module

val persistentModule = module {
    single<PokedexDatabase> {
        Room.databaseBuilder(
            get(),
            PokedexDatabase::class.java,
            "pokedex_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    includes(daoModule)
}