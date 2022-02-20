package com.kmm.news.data.source.remote

import com.kmm.news.data.source.NewsDataSource
import com.kmm.news.data.source.remote.entity.NetworkArticle
import com.kmm.news.data.source.remote.entity.NetworkNews
import com.kmm.news.di.NetworkModule
import com.kmm.news.model.Headline
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Created by Prasada Rao on 20/02/22 3:55 PM
 **/
class NewsRemoteDataSource(
  private val httpClient: HttpClient = NetworkModule.provideHttpClient()
) : NewsDataSource {
  override suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>> {
    return runCatching<List<Headline>> {
      val response: NetworkNews = httpClient.get(Apis.Movies)

      response.articles.map { article ->
        article.convertToDomainEntity(page)
      }
    }.onSuccess {
      Result.success(it)
    }.onFailure {
      Result.failure<Throwable>(it)
    }
  }

  override suspend fun saveHeadlines(headlines: List<Headline>) {
    TODO("Not yet implemented")
  }

  private fun NetworkArticle.convertToDomainEntity(page: Int): Headline {
    return Headline(
      title = title,
      description = description,
      imageUrl = imageUrl,
      date = datePublished.substring(0, datePublished.indexOf('T')),
      source = source.name,
      page = page
    )
  }
}
