package com.kmm.news.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.kmm.news.android.ui.headline.HeadlinesScreen
import com.kmm.news.android.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Prasada Rao on 20/02/22 10:11 AM
 **/
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyTheme {
        NewsApp()
      }
    }
  }

  @Composable
  fun NewsApp() {
    HeadlinesScreen(onHeadlineClicked = {})
  }
}
