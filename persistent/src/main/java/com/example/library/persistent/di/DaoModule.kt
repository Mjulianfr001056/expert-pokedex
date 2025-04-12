package com.example.library.persistent.di

import com.example.library.persistent.PokedexDatabase
import com.example.library.persistent.dao.FavoriteDao
import com.example.library.persistent.dao.PokemonDao
import org.koin.dsl.module

internal val daoModule = module {
    single<PokemonDao> {
        val database = get<PokedexDatabase>()
        database.pokemonDao()
    }

    single<FavoriteDao> {
        val database = get<PokedexDatabase>()
        database.favoriteDao()
    }
}