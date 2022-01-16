package com.pasukanlangit.id.moviekmm.datasource.network

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual class KtorClientEngine {
    actual fun getEngine(): HttpClientEngine = Android.create()
}
