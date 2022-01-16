package com.pasukanlangit.id.moviekmm.datasource.network

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual class KtorClientEngine {
    actual fun getEngine(): HttpClientEngine = Ios.create()
}

