package com.kmm.news.data

import com.kmm.news.data.source.NewsDataSource
import com.kmm.news.data.source.remote.NewsRemoteDataSource
import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 20/02/22 4:11 PM
 **/
class DefaultNewsRepository(
  private val local: NewsDataSource,
  private val remote: NewsDataSource = NewsRemoteDataSource()
) : NewsRepository {
  override suspend fun fetchHeadlines(page: Int, pageSize: Int, forceReload: Boolean): Result<List<Headline>> {
    val cachedHeadlines = local.fetchHeadlines(page, pageSize)
    return if (!cachedHeadlines.getOrNull().isNullOrEmpty() && !forceReload) {
      cachedHeadlines
    } else {
      remote.fetchHeadlines(page, pageSize).also { networkResult ->
        local.saveHeadlines(networkResult.getOrElse { emptyList() })
      }
    }
  }
}