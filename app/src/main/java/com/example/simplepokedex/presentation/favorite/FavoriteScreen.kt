package com.example.simplepokedex.presentation.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.simplepokedex.presentation.home.PokedexEntry
import com.example.simplepokedex.presentation.navigation.PokedexNavBar
import com.example.simplepokedex.ui.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel,
    navController: NavHostController
) {
    val uiState by viewModel.favoritePokemon.collectAsStateWithLifecycle()
    val favoritePokemon = (uiState as? UiState.Success)?.data ?: emptyList()


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Profile")
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
             PokedexNavBar(
                 navController = navController
             )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
        ) {
            if (favoritePokemon.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "No favorite Pokemon",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
            else
            favoritePokemon.forEach{ pokemon ->
                item {
                    PokedexEntry(
                        pokemon = pokemon,
                        onClick = {
                            navController.navigate("detail/${pokemon.id}")
                        }
                    )
                }
            }
        }
    }
}