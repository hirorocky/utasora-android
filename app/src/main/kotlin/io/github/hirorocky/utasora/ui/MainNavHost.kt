package io.github.hirorocky.utasora.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.github.hirorocky.utasora.feature.introspection.IntrospectionRoute
import io.github.hirorocky.utasora.feature.phrases.PhrasesRoute
import io.github.hirorocky.utasora.feature.poems.PoemsRoute
import io.github.hirorocky.utasora.feature.settings.SettingsRoute
import io.github.hirorocky.utasora.feature.signin.SignInRoute
import io.github.hirorocky.utasora.feature.signup.SignUpRoute
import io.github.hirorocky.utasora.feature.splash.SplashRoute
import io.github.hirorocky.utasora.feature.title.TitleRoute
import io.github.hirorocky.utasora.navigation.ScreenDestinations
import io.github.hirorocky.utasora.navigation.clearAndNavigateTo
import io.github.hirorocky.utasora.navigation.navigateTo
import io.github.hirorocky.utasora.navigation.screen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = ScreenDestinations.SplashScreen.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        screen(ScreenDestinations.SplashScreen.route) {
            SplashRoute(
                navigateToTitle = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.TitleScreen.route,
                    )
                },
                navigateToMain = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.PhrasesScreen.route,
                    )
                },
            )
        }
        screen(ScreenDestinations.TitleScreen.route) {
            TitleRoute(
                navigateToSignUp = {
                    navController.navigateTo(ScreenDestinations.SignUpScreen.route)
                },
                navigateToSignIn = {
                    navController.navigateTo(ScreenDestinations.SignInScreen.route)
                },
            )
        }
        screen(ScreenDestinations.SignUpScreen.route) {
            SignUpRoute(
                navigateToMain = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.PoemsScreen.route,
                    )
                },
            )
        }
        screen(ScreenDestinations.SignInScreen.route) {
            SignInRoute(
                navigateToMain = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.PoemsScreen.route,
                    )
                },
            )
        }
        screen(ScreenDestinations.PhrasesScreen.route) {
            PhrasesRoute()
        }
        screen(ScreenDestinations.PoemsScreen.route) {
            PoemsRoute()
        }
        screen(ScreenDestinations.IntrospectionScreen.route) {
            IntrospectionRoute()
        }
        screen(ScreenDestinations.SettingsScreen.route) {
            SettingsRoute(
                navigateToTitle = {
                    navController.clearAndNavigateTo(
                        route = ScreenDestinations.TitleScreen.route,
                    )
                },
            )
        }
    }
}
