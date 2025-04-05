package com.example.library.networking.di

import com.example.library.networking.client.pokemon.PokemonClient
import com.example.library.networking.client.pokemon.PokemonClientImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkingModule = module{
    includes(clientModule)

    singleOf(::PokemonClientImpl)
        .bind<PokemonClient>()
}