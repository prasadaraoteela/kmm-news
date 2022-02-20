package com.kmm.news.di

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

/**
 * Created by Prasada Rao on 20/02/22 3:43 PM
 **/
object NetworkModule {

  fun provideHttpClient() = HttpClient {
    install(JsonFeature) {
      val json = kotlinx.serialization.json.Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
      }

      serializer = KotlinxSerializer(json)
    }
  }
}