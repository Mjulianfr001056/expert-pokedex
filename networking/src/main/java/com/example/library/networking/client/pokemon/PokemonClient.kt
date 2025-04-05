package com.example.library.networking.client.pokemon

import com.example.library.networking.BuildConfig
import com.example.library.networking.client.pokemon.request.GetPokemonDetailRequest
import com.example.library.networking.client.pokemon.request.GetPokemonListRequest
import com.example.library.networking.client.pokemon.response.GetPokemonDetailResponse
import com.example.library.networking.client.pokemon.response.GetPokemonListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType

interface PokemonClient {
    suspend fun getAllPokemon(request: GetPokemonListRequest): GetPokemonListResponse
    suspend fun getPokemonDetail(request: GetPokemonDetailRequest): GetPokemonDetailResponse
}

internal class PokemonClientImpl(
    val httpClient: HttpClient
) : PokemonClient {
    val baseUrl = BuildConfig.BASE_URL + "pokemon/"

    override suspend fun getAllPokemon(request: GetPokemonListRequest): GetPokemonListResponse {
        return httpClient.get(baseUrl) {
            contentType(ContentType.Application.Json)
            url {
                parameters.append("limit", request.limit.toString())
                parameters.append("offset", request.offset.toString())
            }
        }.body()
    }

    override suspend fun getPokemonDetail(request: GetPokemonDetailRequest): GetPokemonDetailResponse {
        return httpClient.get(baseUrl) {
            contentType(ContentType.Application.Json)
            url{
                appendPathSegments(request.id.toString())
            }
        }.body()
    }
}