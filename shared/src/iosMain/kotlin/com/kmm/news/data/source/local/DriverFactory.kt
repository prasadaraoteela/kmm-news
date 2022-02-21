package com.kmm.news.data.source.local

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

/**
 * Created by Prasada Rao on 21/02/22 11:45 AM
 **/
actual class DriverFactory {
  actual fun createDriver(): SqlDriver {
    return NativeSqliteDriver(schema = NewsDatabase.Schema, name = "NewsDatabase.db")
  }
}