package com.example.library.networking.di

import com.example.library.networking.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.lighthousegames.logging.logging

private val logLevel = when (BuildConfig.BUILD_TYPE) {
    "debug" -> LogLevel.ALL
    else -> LogLevel.INFO
}

internal val clientModule = module {
    single<HttpClient> {
        HttpClient(get()){
            install(Logging) {
                level = logLevel
                logger = object : Logger {
                    override fun log(message: String) {
                        logging().d("NETWORKING_MODULE") { message }
                    }
                }
            }

            install(ContentNegotiation){
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
}