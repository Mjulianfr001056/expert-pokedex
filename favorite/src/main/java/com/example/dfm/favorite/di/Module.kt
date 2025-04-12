package com.example.dfm.favorite.di

import com.example.dfm.favorite.presentation.favorite.FavoriteViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val favoriteModule = module {
    viewModelOf(::FavoriteViewModel)
}