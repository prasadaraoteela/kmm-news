package com.kmm.news.data.source.local

import com.kmm.news.data.source.NewsDataSource
import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 21/02/22 12:16 PM
 **/
class NewsLocalDataSource(
  private val database: Database
) : NewsDataSource {

  override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {
    return Result.success(database.findAllHeadlines())
  }

  override suspend fun saveHeadlines(headlines: List<Headline>) {
    database.insertHeadlines(headlines)
  }
}