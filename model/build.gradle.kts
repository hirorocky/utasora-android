plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "io.github.hirorocky.utasora.model"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdkVersion.get().toInt()
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Development
    implementation(libs.timber)
}
