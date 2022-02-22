plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = 31
  defaultConfig {
    applicationId = "com.kmm.news.android"
    minSdk = 21
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"
    vectorDrawables {
      useSupportLibrary = true
    }
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.2.0-alpha02"
  }
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
}

dependencies {
  implementation(project(":shared"))
  implementation("com.google.android.material:material:1.5.0")
  implementation("androidx.appcompat:appcompat:1.4.1")
  implementation("androidx.constraintlayout:constraintlayout:2.1.3")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")


  implementation("androidx.core:core-ktx:1.7.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

  val composeVersion = "1.2.0-alpha02"

  implementation("androidx.compose.ui:ui:$composeVersion")
  // Tooling support (Previews, etc.)
  implementation("androidx.compose.ui:ui-tooling:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
  // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
  implementation("androidx.compose.foundation:foundation:$composeVersion")
  // Material Design
  implementation("androidx.compose.material:material:$composeVersion")
  // Material design icons
  implementation("androidx.compose.material:material-icons-core:$composeVersion")
  implementation("androidx.compose.material:material-icons-extended:$composeVersion")
  // Integration with activities
  implementation("androidx.activity:activity-compose:1.4.0")
  // Integration with ViewModels
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
  // Integration with observables
  implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
  implementation("androidx.compose.runtime:runtime-rxjava2:$composeVersion")

  // UI Tests
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

  // Constraint layout
  implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0")

  // Jetpack compose navigation library
  implementation("androidx.navigation:navigation-compose:2.5.0-alpha02")

  // Coil image loading library
  implementation("io.coil-kt:coil-compose:1.4.0")

  // GSON
  implementation("com.google.code.gson:gson:2.8.9")

  // Kotlin LiveData extensions
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

  // Hilt DI library
  implementation("com.google.dagger:hilt-android:2.40.5")
  kapt("com.google.dagger:hilt-compiler:2.40.5")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}