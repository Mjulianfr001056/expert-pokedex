package com.example.library.core.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface ComposableFeatureEntry {
    val route: String
    val destination: String

    fun register(navGraphBuilder: NavGraphBuilder, navController: NavHostController)
}

interface ComposableFeatureEntryWithArgs : ComposableFeatureEntry {
    fun registerWithArgs(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    )
}
