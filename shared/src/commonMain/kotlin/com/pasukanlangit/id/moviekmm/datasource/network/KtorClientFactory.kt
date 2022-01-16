package com.pasukanlangit.id.moviekmm.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

class KtorClientFactory {
    fun build(ktorClientEngine: KtorClientEngine): HttpClient =
        HttpClient(ktorClientEngine.getEngine()){
            install(JsonFeature){
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Logging){
                level = LogLevel.ALL
            }
        }
}

expect class KtorClientEngine {
    fun getEngine(): HttpClientEngine
}