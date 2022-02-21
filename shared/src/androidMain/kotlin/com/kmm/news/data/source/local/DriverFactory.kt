package com.kmm.news.data.source.local

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Prasada Rao on 21/02/22 11:39 AM
 **/
actual class DriverFactory(
  private val context: Context
) {
  actual fun createDriver(): SqlDriver {
    return AndroidSqliteDriver(schema = NewsDatabase.Schema, context = context, name = "NewsDatabase.db")
  }
}