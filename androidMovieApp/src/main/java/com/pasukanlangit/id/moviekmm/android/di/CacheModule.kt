package com.pasukanlangit.id.moviekmm.android.di

import android.app.Application
import com.pasukanlangit.id.moviekmm.datasource.cache.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideRecipeDatabase(application: Application): AflixDatabase =
        AflixDatabaseFactory(
            driverFactory = DriverFactory(context = application)
        ).createDatabase()

    @Provides
    @Singleton
    fun provideRecipeCache(db: AflixDatabase): AflixCache =
        AflixCacheImpl(
            aflixDatabase = db
        )
}