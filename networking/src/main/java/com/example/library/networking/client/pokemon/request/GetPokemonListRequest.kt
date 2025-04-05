package com.example.library.networking.client.pokemon.request

data class GetPokemonListRequest(
    val limit: Int = 20,
    val offset: Int = 0,
)
