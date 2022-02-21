package com.kmm.news.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kmm.news.Greeting
import com.kmm.news.data.DefaultNewsRepository
import com.kmm.news.data.NewsRepository
import com.kmm.news.data.source.local.DriverFactory
import com.kmm.news.data.source.local.NewsLocalDataSource
import com.kmm.news.di.DatabaseModule
import com.kmm.news.model.Headline
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

fun greet(): String {
  return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

  private val mainScope = MainScope()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val tv: TextView = findViewById(R.id.text_view)
    tv.text = greet()

    val repository: NewsRepository =
      DefaultNewsRepository(local = NewsLocalDataSource(DatabaseModule.provideDatabase(DriverFactory(this))))

    mainScope.launch {
      repository.fetchHeadlines(1, 20, false)
        .onSuccess { headlines: List<Headline> -> println("========> Success $headlines") }
        .onFailure { it.printStackTrace() }
    }
  }
}
