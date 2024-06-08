package io.github.hirorocky.utasora.navigation

sealed class ScreenDestinations(val route: String) {
    data object SplashScreen : ScreenDestinations("splash_screen")

    data object TitleScreen : ScreenDestinations("title_screen")

    data object SignUpScreen : ScreenDestinations("sign_up_screen")

    data object SignInScreen : ScreenDestinations("sign_in_screen")

    data object PhrasesScreen : ScreenDestinations("phrase_screen")

    data object PoemsScreen : ScreenDestinations("poem_screen")

    data object IntrospectionScreen : ScreenDestinations("introspection_screen")

    data object SettingsScreen : ScreenDestinations("settings_screen")
}
