package com.kmm.news.data.source

import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 20/02/22 1:17 PM
 **/
interface NewsDataSource {

  suspend fun fetchHeadlines(page: Int, pageSize: Int): Result<List<Headline>>

  suspend fun saveHeadlines(headlines: List<Headline>)
}