package com.pasukanlangit.id.moviekmm.datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(AflixDatabase.Schema, AflixDatabaseFactory.AFLIX_DATABASE_NAME)
}