package com.pasukanlangit.id.moviekmm.android.di

import com.pasukanlangit.id.moviekmm.datasource.network.ApiService
import com.pasukanlangit.id.moviekmm.datasource.network.ApiServiceImpl
import com.pasukanlangit.id.moviekmm.datasource.network.KtorClientEngine
import com.pasukanlangit.id.moviekmm.datasource.network.KtorClientFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideKtorClientEngine() = KtorClientEngine()

    @Provides
    @Singleton
    fun provideHttpClient(ktorClientEngine: KtorClientEngine): HttpClient =
        KtorClientFactory().build(ktorClientEngine)

    @Provides
    @Singleton
    fun provideApiService(httpClient: HttpClient): ApiService =
        ApiServiceImpl(httpClient)
}