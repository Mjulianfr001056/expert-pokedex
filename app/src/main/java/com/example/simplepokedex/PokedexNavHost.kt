package com.example.simplepokedex

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.library.core.presentation.home.HomeScreen
import com.example.library.core.presentation.home.HomeViewModel
import com.example.library.core.presentation.profile.ProfileScreen
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import org.koin.compose.koinInject

@Composable
fun PokedexNavHost(
    navController: NavHostController
) {
    val context = LocalContext.current
    val splitInstallManager = SplitInstallManagerFactory.create(context)
    val moduleFavorite = "favorite"

    NavHost(
        navController = navController,
        startDestination = "home",
    ){
        composable("home"){
            val viewModel = koinInject<HomeViewModel>()

            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )

        }

        composable("detail/{id}") {
            val id = it.arguments?.getString("id") ?: ""
            val route = "detail"

            LaunchedEffect(moduleFavorite) {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("app://com.example.dfm.favorite")
                    `package` = context.packageName
                }

                intent.putExtra("route", route)
                intent.putExtra("id", id)

                if (splitInstallManager.installedModules.contains(moduleFavorite)) {
                    context.startActivity(intent)
                    (context as? Activity)?.finish()
                } else {
                    val request = SplitInstallRequest.newBuilder()
                        .addModule(moduleFavorite)
                        .build()

                    splitInstallManager.startInstall(request)
                        .addOnSuccessListener {
                            context.startActivity(intent)
                            (context as? Activity)?.finish()
                        }
                }
            }
        }

        composable("profile") {
            ProfileScreen(
                navController = navController
            )
        }

        composable("favorite") {
            val route = "favorite"

            LaunchedEffect(moduleFavorite) {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("app://com.example.dfm.favorite")
                    `package` = context.packageName
                }

                intent.putExtra("route", route)
                intent.putExtra("id", id)

                if (splitInstallManager.installedModules.contains(moduleFavorite)) {
                    context.startActivity(intent)
                    (context as? Activity)?.finish()
                } else {
                    val request = SplitInstallRequest.newBuilder()
                        .addModule(moduleFavorite)
                        .build()

                    splitInstallManager.startInstall(request)
                        .addOnSuccessListener {
                            context.startActivity(intent)
                            (context as? Activity)?.finish()
                        }
                }
            }
        }
    }
}