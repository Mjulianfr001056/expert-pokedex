package com.example.library.networking.di

import com.example.library.networking.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.CertificatePinner
import org.koin.dsl.module
import org.lighthousegames.logging.logging

private val logLevel = when (BuildConfig.BUILD_TYPE) {
    "debug" -> LogLevel.ALL
    else -> LogLevel.INFO
}

internal val clientModule = module {
    single<HttpClient> {
        val hostname = "pokeapi.co"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/HalE3pYIF9UcO2Kezl94iZ9gdnC6nVMZoT0IYqhPBHM=")
            .add(hostname, "sha256/kIdp6NNEd8wsugYyyIYFsi1ylMCED3hZbSR8ZFsa/A4=")
            .add(hostname, "sha256/mEflZT5enoR1FuXLgYYGqnVEoZvmf9c2bVBpiOjYQ0c=")
            .build()

        HttpClient(OkHttp){
            engine {
                preconfigured = okhttp3.OkHttpClient.Builder()
                    .certificatePinner(certificatePinner)
                    .build()
            }

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