package com.example.library.core.di

import com.example.library.core.data.PokemonRepository
import com.example.library.core.data.PokemonRepositoryImpl
import com.example.library.core.domain.usecase.PokemonUseCase
import com.example.library.core.domain.usecase.PokemonUseCaseImpl
import com.example.library.core.presentation.home.HomeViewModel
import com.example.library.networking.di.networkingModule
import com.example.library.persistent.di.persistentModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    includes(
        persistentModule,
        networkingModule,
    )
    viewModelOf(::HomeViewModel)

    singleOf(::PokemonUseCaseImpl)
        .bind<PokemonUseCase>()

    singleOf(::PokemonRepositoryImpl)
        .bind<PokemonRepository>()
}