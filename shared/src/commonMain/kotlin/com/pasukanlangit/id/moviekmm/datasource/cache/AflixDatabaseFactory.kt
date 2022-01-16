package com.pasukanlangit.id.moviekmm.datasource.cache

import com.squareup.sqldelight.db.SqlDriver

class AflixDatabaseFactory(
    private val driverFactory: DriverFactory
) {
    fun createDatabase(): AflixDatabase =
        AflixDatabase(driver = driverFactory.createDriver())

    companion object {
        const val AFLIX_DATABASE_NAME = "aflix.db"
    }
}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}