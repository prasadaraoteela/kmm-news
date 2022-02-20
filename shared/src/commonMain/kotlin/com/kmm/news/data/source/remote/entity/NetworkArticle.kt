package com.kmm.news.data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Prasad Rao on 10-08-2020 19:45
 **/
@Serializable
data class NetworkArticle(
  @SerialName("author")
  val author: String = "",

  val title: String,

  @SerialName("description")
  val description: String,

  @SerialName("url")
  val url: String,

  @SerialName("urlToImage")
  val imageUrl: String,

  @SerialName("publishedAt")
  val datePublished: String,

  @SerialName("content")
  val content: String? = null,

  @SerialName("source")
  val source: NetworkArticleSource
)