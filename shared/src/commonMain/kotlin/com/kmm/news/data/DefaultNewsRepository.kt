package com.kmm.news.data

import com.kmm.news.data.source.NewsDataSource
import com.kmm.news.data.source.remote.NewsRemoteDataSource
import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 20/02/22 4:11 PM
 **/
class DefaultNewsRepository(
  private val remote: NewsDataSource = NewsRemoteDataSource()
) : NewsRepository {
  override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {
    return remote.fetchHeadlines(page, pageSize)
  }
}