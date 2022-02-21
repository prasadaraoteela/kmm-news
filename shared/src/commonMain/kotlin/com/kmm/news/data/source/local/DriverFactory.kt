package com.kmm.news.data.source.local

import com.squareup.sqldelight.db.SqlDriver

/**
 * Created by Prasada Rao on 21/02/22 11:33 AM
 **/
expect class DriverFactory {
  fun createDriver(): SqlDriver
}