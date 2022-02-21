package com.kmm.news.android.ui.headline

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 21/02/22 4:51 PM
 **/
@Composable
fun HeadlineList(
  headlines: List<Headline>,
  onHeadlineClicked: (Headline) -> Unit
) {
  LazyColumn(
    contentPadding = PaddingValues(16.dp)
  ) {
    items(headlines) { headline ->
      HeadlineCard(
        headline = headline,
        onHeadlineClicked = onHeadlineClicked
      )
    }
  }
}
