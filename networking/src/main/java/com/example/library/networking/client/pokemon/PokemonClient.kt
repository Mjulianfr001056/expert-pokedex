package com.example.library.networking.client.pokemon

import com.example.library.networking.BuildConfig
import com.example.library.networking.client.pokemon.request.GetPokemonByNameRequest
import com.example.library.networking.client.pokemon.request.GetPokemonListRequest
import com.example.library.networking.client.pokemon.response.GetPokemonDetailResponse
import com.example.library.networking.client.pokemon.response.GetPokemonListResponse
import com.example.library.networking.client.pokemon.response.GetPokemonSpeciesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType

interface PokemonClient {
    suspend fun getPokemonList(request: GetPokemonListRequest): GetPokemonListResponse
    suspend fun getPokemonDetailByName(request: GetPokemonByNameRequest): GetPokemonDetailResponse
    suspend fun getPokemonSpeciesByName(request: GetPokemonByNameRequest): GetPokemonSpeciesResponse
}

internal class PokemonClientImpl(
    private val httpClient: HttpClient
) : PokemonClient {
    private val baseUrl = BuildConfig.BASE_URL

    override suspend fun getPokemonList(request: GetPokemonListRequest): GetPokemonListResponse {
        return httpClient.get(baseUrl + "pokemon/") {
            contentType(ContentType.Application.Json)
            url {
                parameters.append("limit", request.limit.toString())
                parameters.append("offset", request.offset.toString())
            }
        }.body()
    }

    override suspend fun getPokemonDetailByName(request: GetPokemonByNameRequest): GetPokemonDetailResponse {
        return httpClient.get(baseUrl + "pokemon/") {
            contentType(ContentType.Application.Json)
            url{
                appendPathSegments(request.name)
            }
        }.body()
    }

    override suspend fun getPokemonSpeciesByName(request: GetPokemonByNameRequest): GetPokemonSpeciesResponse {
        return httpClient.get(baseUrl + "pokemon-species/") {
            contentType(ContentType.Application.Json)
            url{
                appendPathSegments(request.name)
            }
        }.body()
    }
}