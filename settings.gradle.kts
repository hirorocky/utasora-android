pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Utasora"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":data")
include(":domain")
include(":navigation")
include(":theme")
include(":ui")
include(":model")
include(":feature:introspection")
include(":feature:phrases")
include(":feature:poems")
include(":feature:settings")
include(":feature:signin")
include(":feature:signup")
include(":feature:splash")
include(":feature:title")