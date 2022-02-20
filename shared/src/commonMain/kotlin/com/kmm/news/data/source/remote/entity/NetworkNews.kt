package com.kmm.news.data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Prasad Rao on 10-08-2020 19:44
 **/
@Serializable
data class NetworkNews(
    @SerialName("status")
    val status: String,

    @SerialName("totalResults")
    val totalResults: Long,

    @SerialName("message")
    val message: String? = null,

    @SerialName("articles")
    val articles: List<NetworkArticle> = emptyList()
)