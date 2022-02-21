package com.kmm.news.android.di

import android.content.Context
import com.kmm.news.data.DefaultNewsRepository
import com.kmm.news.data.NewsRepository
import com.kmm.news.data.source.local.Database
import com.kmm.news.data.source.local.DriverFactory
import com.kmm.news.data.source.local.NewsLocalDataSource
import com.kmm.news.di.DatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Prasada Rao on 21/02/22 5:00 PM
 **/
@InstallIn(ViewModelComponent::class)
@Module
object NewsDataModule {

  @ViewModelScoped
  @Provides
  fun provideNewsRepository(
    database: Database
  ): NewsRepository {
    return DefaultNewsRepository(local = NewsLocalDataSource(database))
  }

  @Provides
  fun provideNewsDatabase(
    @ApplicationContext applicationContext: Context
  ): Database {
    return DatabaseModule.provideDatabase(DriverFactory(applicationContext))
  }
}