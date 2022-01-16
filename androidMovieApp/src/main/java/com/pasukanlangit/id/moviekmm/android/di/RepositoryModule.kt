package com.pasukanlangit.id.moviekmm.android.di

import com.pasukanlangit.id.moviekmm.datasource.MainRepositoryImpl
import com.pasukanlangit.id.moviekmm.datasource.cache.AflixCache
import com.pasukanlangit.id.moviekmm.datasource.network.ApiService
import com.pasukanlangit.id.moviekmm.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(apiService: ApiService, aflixCache: AflixCache): MainRepository =
        MainRepositoryImpl(apiService, aflixCache)
}