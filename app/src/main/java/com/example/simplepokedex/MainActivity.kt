package com.example.simplepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.library.core.ui.theme.SimplePokedexTheme
import org.koin.compose.KoinContext

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
