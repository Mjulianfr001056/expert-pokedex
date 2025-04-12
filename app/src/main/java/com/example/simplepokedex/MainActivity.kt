package com.example.simplepokedex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.library.core.presentation.navigation.ComposableFeatureEntry
import com.example.library.core.ui.theme.SimplePokedexTheme
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplePokedexTheme {
                KoinContext {
                    val navController = rememberNavController()

                    PokedexNavHost(navController = navController)
                }
            }
        }
    }
}
