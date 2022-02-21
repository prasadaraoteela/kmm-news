package com.kmm.news.di

import com.kmm.news.data.source.local.Database
import com.kmm.news.data.source.local.DriverFactory

/**
 * Created by Prasada Rao on 21/02/22 12:14 PM
 **/
object DatabaseModule {

  fun provideDatabase(
    databaseDriverFactory: DriverFactory
  ): Database {
    return Database(databaseDriverFactory)
  }
}