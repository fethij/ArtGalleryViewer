<img src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/4da3ef7d-9809-4f0e-9f27-31b3991ab721">

# Art gallery viewer
Android application using the Rijksmuseum rich and [freely accessible content](https://www.rijksmuseum.nl/en/data/policy).
You can filter arts based on production places.


## Getting started 📦

There are a few ways to open this project.

### Android Studio <img width="30" align="center" src="https://slackmojis.com/emojis/4696-android_studio/download">

1. `Android Studio` -> `File` -> `New` -> `From Version control` -> `Git`
2. Enter `https://github.com/fethij/ArtGalleryViewer.git` into URL field an press `Clone` button

### Command-line + Android Studio <img width="30" align="center" src="https://slackmojis.com/emojis/1263-terminal/download">

1. Run `git clone https://github.com/fethij/ArtGalleryViewer.git` command to clone project
2. Open `Android Studio` and select `File | Open...` from the menu. Select cloned directory and press `Open` button

# Add API key

1. git clone repo to Android studio
2. Get your own Api Key from [Rijksmuseum.nl](https://data.rijksmuseum.nl/object-metadata/api/)
3. Add your own Api Key to gradle.properties/local.properties in this format

   RijksmuseumApiKey=<YOUR_API_KEY>

4. And run in emulator or on physical device
 

## Design
Design is inspired by [Mari Andrianova](https://dribbble.com/shots/20446337-Gallery-of-art-App).

<img width="240" alt="s2" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/a46b7b5b-d2d3-4d27-a897-5c81ae6439c7"><img width="240" alt="s1" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/2056de1e-6841-4455-bc95-6ffbdaec1542"><img width="240" alt="s2" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/241f9f7e-f926-4885-a448-b2a6769c7518">

<img width="240" alt="s1" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/4cb65274-aa61-4c78-9439-874d655a2295"><img width="240" alt="s2" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/c8a96798-e180-4902-aba7-58602167bde8"><img width="240" alt="s2" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/0db53073-29bb-4cf8-8f4c-3dcf3fe64fb3">


## Modularization
<img alt="Multi-modular" src="https://github.com/fethij/ArtGalleryViewer/assets/32542424/408ed42c-fdd0-4366-9e24-6c55c3fdef99">

## Tech Stack
  * 100% [Kotlin](https://kotlinlang.org/)
  * [Coroutines/Flow](https://kotlinlang.org/docs/coroutines-overview.html) - Concurrency
  * [Retrofit](https://github.com/square/retrofit) - networking
  * [Jetpack](https://developer.android.com/jetpack)
  * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - handles logic between UI and *Repository* using **Flows**
  * [Jetpack Compose](https://developer.android.com/jetpack/compose) - latest reactive ui toolkit by Google
  * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - for dependency injection
  * [Coil](https://github.com/coil-kt/coil) - for fetching images from web

* Modern Architecture
  * Clean Architecture
  * Modularization - multi-modular
  * Single activity
  * [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) architecture

* UI
  * [Material3 design]([https://material.io/design](https://m3.material.io/))
  * Compose - reactive UI

* Testing
  * Unit Tests
  * [Instrumneted Tests using Robolectric](https://robolectric.org/)

* Gradle
  * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
