android {
  defaultConfig {
    vectorDrawables {
      useSupportLibrary = true
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
      excludes += '/META-INF/{AL2.0,LGPL2.1}'
    }
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.7.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

  val compose_version = "1.2.0-alpha02"

  implementation("androidx.compose.ui:ui:$compose_version")
  // Tooling support (Previews, etc.)
  implementation("androidx.compose.ui:ui-tooling:$compose_version")
  implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
  // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
  implementation("androidx.compose.foundation:foundation:$compose_version")
  // Material Design
  implementation("androidx.compose.material:material:$compose_version")
  // Material design icons
  implementation("androidx.compose.material:material-icons-core:$compose_version")
  implementation("androidx.compose.material:material-icons-extended:$compose_version")
  // Integration with activities
  implementation("androidx.activity:activity-compose:1.4.0")
  // Integration with ViewModels
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
  // Integration with observables
  implementation("androidx.compose.runtime:runtime-livedata:$compose_version")
  implementation("androidx.compose.runtime:runtime-rxjava2:$compose_version")

  // UI Tests
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")

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
}