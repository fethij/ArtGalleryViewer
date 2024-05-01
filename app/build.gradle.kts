plugins {
    alias(libs.plugins.artGalleryViewer.android.application)
    alias(libs.plugins.artGalleryViewer.android.application.compose)
    alias(libs.plugins.artGalleryViewer.android.hilt)
}

android {
    namespace = "com.example.artGalleryViewer"

    defaultConfig {
        applicationId = "com.example.artGalleryViewer"
        versionCode = 1
        versionName = "1.0"

        // Custom test runner to set up Hilt dependency graph
        testInstrumentationRunner =
            "com.example.artGalleryViewer.core.testing.ArtGalleryViewerTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.designsystem)
    implementation(projects.feature.arts)

    implementation(libs.androidx.activity.compose)
    implementation(libs.material)
    implementation(libs.coil.compose)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.common.ktx)
}