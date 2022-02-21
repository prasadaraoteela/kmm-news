package com.kmm.news.android.ui.headline

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kmm.news.model.Headline

/**
 * Created by Prasada Rao on 21/02/22 4:52 PM
 **/
@Composable
fun HeadlineCard(
  modifier: Modifier = Modifier,
  headline: Headline,
  onHeadlineClicked: (Headline) -> Unit = {}
) {

  Card(
    shape = RoundedCornerShape(size = 8.dp),
    elevation = 2.dp,
    modifier = modifier
      .fillMaxWidth()
      .padding(top = 16.dp)
      .clickable { onHeadlineClicked(headline) }
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Image(
        painter = rememberImagePainter(data = headline.imageUrl),
        contentDescription = headline.title,
        modifier = Modifier
          .clip(RoundedCornerShape(8.dp))
          .height(120.dp)
          .fillMaxWidth(),
        contentScale = ContentScale.Crop,
      )
      Text(
        text = headline.title,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(top = 8.dp)
      )
      CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
          text = headline.description,
          style = MaterialTheme.typography.subtitle2,
          maxLines = 3,
          overflow = TextOverflow.Ellipsis
        )
      }
    }
  }
}