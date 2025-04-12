package com.example.dfm.favorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.dfm.favorite.di.favoriteModule
import com.example.dfm.favorite.presentation.LocalPokedexNavHost
import com.example.library.core.di.coreModule
import com.example.library.core.ui.theme.SimplePokedexTheme
import org.koin.compose.KoinContext
import org.koin.core.context.loadKoinModules

class FavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplePokedexTheme {
                KoinContext {
                    loadKoinModules(
                        listOf(
                            favoriteModule,
                            coreModule
                        )
                    )

                    val navController = rememberNavController()
                    val start = intent.extras?.getString("route") ?: "favorite"
                    val id = intent.extras?.getString("id")?.toInt() ?: 0

                    LocalPokedexNavHost(navController, start, id)
                }
            }
        }
    }
}
