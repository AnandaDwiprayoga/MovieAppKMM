package com.pasukanlangit.id.moviekmm.datasource.cache

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(AflixDatabase.Schema, context, AflixDatabaseFactory.AFLIX_DATABASE_NAME)
}