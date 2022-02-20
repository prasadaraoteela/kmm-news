package com.kmm.news.model

/**
 * Created by Prasada Rao on 20/02/22 1:14 PM
 **/
data class Headline(
  val title: String,
  val description: String,
  val imageUrl: String,
  val date: String,
  val source: String,
  val page: Int = 1
)
