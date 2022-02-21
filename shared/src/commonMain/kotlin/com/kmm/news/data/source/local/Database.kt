package com.kmm.news.data.source.local

import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 21/02/22 11:55 AM
 **/
class Database(
  databaseDriverFactory: DriverFactory
) {
  private val database = NewsDatabase(driver = databaseDriverFactory.createDriver())
  private val queries = database.newsDatabaseQueries

  fun findAllHeadlines(): List<Headline> {
    return queries.findAllHeadlines(::mapHeadline).executeAsList()
  }

  fun insertHeadlines(headlines: List<Headline>) {
    queries.transaction {
      clearHeadlines()
      headlines.forEach { headline ->
        insertHeadline(headline)
      }
    }
  }

  private fun insertHeadline(headline: Headline) {
    queries.insertHeadline(
      title = headline.title,
      description = headline.description,
      image_url = headline.imageUrl,
      date = headline.date,
      news_source = headline.source,
      page = headline.page.toLong()
    )
  }

  private fun clearHeadlines() {
    queries.removeHeadlines()
  }

  private fun mapHeadline(
    title: String,
    description: String,
    imageUrl: String,
    date: String,
    source: String,
    page: Long
  ): Headline {
    return Headline(
      title = title,
      description = description,
      imageUrl = imageUrl,
      date = date,
      source = source,
      page = page.toInt()
    )
  }
}