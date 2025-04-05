package com.example.simplepokedex.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PokedexNavBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar {
        NavigationBarItem(
            selected = navController.currentDestination?.route == "home",
            onClick = {
                navController.navigate("home")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")
            }
        )
        NavigationBarItem(
            selected = navController.currentDestination?.route == "favorite",
            onClick = {
                navController.navigate("favorite")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null
                )
            },
            label = {
                Text("Favorite")
            }
        )
        NavigationBarItem(
            selected = navController.currentDestination?.route == "profile",
            onClick = {
                navController.navigate("profile")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "about_page"
                )
            },
            label = {
                Text("Profile")
            }
        )
    }
}

@Composable
@Preview
fun PokedexNavBarPreview(modifier: Modifier = Modifier) {
    PokedexNavBar(
        navController = rememberNavController()
    )
}