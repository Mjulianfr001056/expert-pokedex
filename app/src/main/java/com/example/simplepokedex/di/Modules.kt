package com.example.simplepokedex.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simplepokedex.data.PokemonRepository
import com.example.simplepokedex.data.PokemonRepositoryImpl
import com.example.simplepokedex.data.local.PokedexDatabase
import com.example.simplepokedex.data.local.PokemonDao
import com.example.simplepokedex.domain.usecase.FavoritePokemonUseCase
import com.example.simplepokedex.domain.usecase.FavoritePokemonUseCaseImpl
import com.example.simplepokedex.domain.usecase.PokemonUseCase
import com.example.simplepokedex.domain.usecase.PokemonUseCaseImpl
import com.example.simplepokedex.presentation.detail.DetailViewModel
import com.example.simplepokedex.presentation.favorite.FavoriteViewModel
import com.example.simplepokedex.presentation.home.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::PokemonRepositoryImpl).bind<PokemonRepository>()

    single<PokedexDatabase> {
        Room.databaseBuilder(get(),
            PokedexDatabase::class.java,
            "pokedex_database")
            .build()
    }

    single<PokemonDao> {
        val database = get<PokedexDatabase>()
        database.pokemonDao()
    }
}

val useCaseModule = module {
    singleOf(::PokemonUseCaseImpl).bind<PokemonUseCase>()
    singleOf(::FavoritePokemonUseCaseImpl).bind<FavoritePokemonUseCase>()
}

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
    viewModelOf(::FavoriteViewModel)
}