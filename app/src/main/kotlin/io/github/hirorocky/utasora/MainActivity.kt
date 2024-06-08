package io.github.hirorocky.utasora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.hirorocky.utasora.theme.AppTheme
import io.github.hirorocky.utasora.ui.BottomNavBar
import io.github.hirorocky.utasora.ui.MainNavHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(navController = navController)
                        },
                    ) { innerPaddingModifier ->
                        MainNavHost(
                            navController = navController,
                            modifier = Modifier
                                .padding(innerPaddingModifier)
                                .background(color = MaterialTheme.colorScheme.surface),
                        )
                    }
                }
            }
        }
    }
}
