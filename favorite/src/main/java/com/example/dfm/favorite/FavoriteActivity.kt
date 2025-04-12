package com.example.dfm.favorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.dfm.favorite.di.favoriteModule
import com.example.dfm.favorite.presentation.favorite.FavoriteScreen
import com.example.dfm.favorite.presentation.favorite.FavoriteViewModel
import com.example.library.core.di.coreModule
import com.example.library.core.ui.theme.SimplePokedexTheme
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
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
                    val viewModel = koinInject<FavoriteViewModel>()

                    FavoriteScreen(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
