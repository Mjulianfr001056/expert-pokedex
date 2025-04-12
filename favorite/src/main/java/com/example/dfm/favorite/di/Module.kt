package com.example.dfm.favorite.di

import com.example.dfm.favorite.data.FavoriteRepository
import com.example.dfm.favorite.data.FavoriteRepositoryImpl
import com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCase
import com.example.dfm.favorite.domain.usecase.FavoritePokemonUseCaseImpl
import com.example.dfm.favorite.presentation.detail.DetailViewModel
import com.example.dfm.favorite.presentation.favorite.FavoriteViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val favoriteModule = module {
    viewModelOf(::FavoriteViewModel)
    viewModelOf(::DetailViewModel)

    singleOf(::FavoritePokemonUseCaseImpl)
        .bind<FavoritePokemonUseCase>()

    singleOf(::FavoriteRepositoryImpl)
        .bind<FavoriteRepository>()
}