package com.example.simplepokedex

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.library.core.presentation.home.HomeScreen
import com.example.library.core.presentation.home.HomeViewModel
import com.example.library.core.presentation.profile.ProfileScreen
import org.koin.compose.koinInject

@Composable
fun PokedexNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            val viewModel = koinInject<HomeViewModel>()

            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )

        }

        composable("detail/{id}") {
            val viewModel = koinInject<DetailViewModel>()
            val id = it.arguments?.getString("id") ?: ""

            DetailScreen(
                viewModel = viewModel,
                navController = navController,
                id = id.toInt()
            )
        }

        composable("profile") {
            ProfileScreen(
                navController = navController
            )
        }

        composable("favorite") {
            val viewModel = koinInject<FavoriteViewModel>()

            FavoriteScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}