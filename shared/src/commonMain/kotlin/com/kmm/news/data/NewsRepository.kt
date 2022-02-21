package com.kmm.news.data

import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 20/02/22 1:12 PM
 **/
interface NewsRepository {

  suspend fun fetchHeadlines(page: Int, pageSize: Int, forceReload: Boolean = false): Result<List<Headline>>
}