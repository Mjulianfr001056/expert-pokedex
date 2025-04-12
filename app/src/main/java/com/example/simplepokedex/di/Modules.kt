package com.example.simplepokedex.di

import com.example.simplepokedex.data.PokemonRepository
import com.example.simplepokedex.data.PokemonRepositoryImpl
import com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCase
import com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCaseImpl
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
    singleOf(::PokemonRepositoryImpl)
        .bind<PokemonRepository>()
}

val useCaseModule = module {
    singleOf(::PokemonUseCaseImpl)
        .bind<PokemonUseCase>()

    singleOf(::FavoritePokemonUseCaseImpl)
        .bind<com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCase>()
}

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
    viewModelOf(::FavoriteViewModel)
}