plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "io.github.hirorocky.utasora.domain"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdkVersion.get().toInt()
    }

    buildFeatures {
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Module
    implementation(projects.data)
    implementation(projects.model)

    // Hilt
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.compose.navigation)
    implementation(libs.hilt.android)

    // Development
    implementation(libs.timber)
}
