package com.kmm.news.data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Prasad Rao on 11-08-2020 11:32
 **/
@Serializable
data class NetworkArticleSource(
  @SerialName("id")
  val id: String? = null,

  @SerialName("name")
  val name: String
)