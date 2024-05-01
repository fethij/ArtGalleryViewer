plugins {
    alias(libs.plugins.artGalleryViewer.android.library)
    alias(libs.plugins.artGalleryViewer.android.hilt)
}

android {
    namespace = "com.example.artGalleryViewer.core.data"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.core.common)
//    implementation(projects.core.datastore)
    implementation(projects.core.network)
    implementation(projects.core.model)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(projects.core.testing)
}
