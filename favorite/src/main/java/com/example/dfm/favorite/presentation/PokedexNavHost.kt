package com.example.dfm.favorite.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dfm.favorite.presentation.detail.DetailScreen
import com.example.dfm.favorite.presentation.detail.DetailViewModel
import com.example.dfm.favorite.presentation.favorite.FavoriteScreen
import com.example.dfm.favorite.presentation.favorite.FavoriteViewModel
import com.example.library.core.presentation.home.HomeScreen
import com.example.library.core.presentation.home.HomeViewModel
import com.example.library.core.presentation.profile.ProfileScreen
import org.koin.compose.koinInject

@Composable
fun LocalPokedexNavHost(
    navController: NavHostController,
    start : String = "favorite",
    id: Int,
) {
    NavHost(
        navController = navController,
        startDestination = start,
    ){
        composable("home"){
            val viewModel = koinInject<HomeViewModel>()

            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable("detail"){
            val viewModel = koinInject<DetailViewModel>()
            val localId = id

            DetailScreen(
                viewModel = viewModel,
                navController = navController,
                id = localId
            )
        }

        composable("detail/{id}") {
            val viewModel = koinInject<DetailViewModel>()
            val localId = it.arguments?.getString("id") ?: ""

            DetailScreen(
                viewModel = viewModel,
                navController = navController,
                id = localId.toInt()
            )
        }

        composable("profile") {
            ProfileScreen(
                navController = navController
            )
        }

        composable("favorite") {
            FavoriteScreen(
                navController = navController,
                viewModel = koinInject<FavoriteViewModel>(),
            )
        }
    }
}