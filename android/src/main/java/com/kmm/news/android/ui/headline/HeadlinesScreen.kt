package com.kmm.news.android.ui.headline

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 21/02/22 4:56 PM
 **/
@Composable
fun HeadlinesScreen(onHeadlineClicked: (Headline) -> Unit) {
  val viewModel: HeadlinesViewModel = hiltViewModel()

  val headlinesResult: Result<List<Headline>>? by viewModel.observeHeadlines().observeAsState()

  headlinesResult?.onSuccess { headlines ->
    HeadlineList(headlines = headlines, onHeadlineClicked = onHeadlineClicked)
  }?.onFailure {
    Text(text = "Failed to load headlines!")
  }
}