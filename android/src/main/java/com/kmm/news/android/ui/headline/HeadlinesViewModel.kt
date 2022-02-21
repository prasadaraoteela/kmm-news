package com.kmm.news.android.ui.headline

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kmm.news.data.NewsRepository
import com.kmm.news.model.Headline
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Prasada Rao on 21/02/22 4:48 PM
 **/
@HiltViewModel
class HeadlinesViewModel @Inject constructor(
  private val repository: NewsRepository
) : ViewModel() {

  fun observeHeadlines(): LiveData<Result<List<Headline>>> = liveData {
    emit(repository.fetchHeadlines(1, 20))
  }
}