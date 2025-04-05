package com.example.simplepokedex.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.simplepokedex.presentation.navigation.PokedexNavBar
import com.example.simplepokedex.ui.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavHostController
) {
    val list by viewModel.pokemonList.collectAsStateWithLifecycle()
    val query by viewModel.query

    Scaffold(
        topBar = { 
            TopAppBar(
                title = {
                     Text(
                         text = "Simple Pokedex",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 24.sp
                            )
                     )
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            PokedexNavBar(
                navController = navController
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerpadding ->
        LazyColumn(
            contentPadding = innerpadding,
        ) {
            item {
                PokedexSearchBar(
                    query = query,
                    onQueryChange = viewModel::search,
                )
            }

            (list as? UiState.Success)?.data?.forEach{ pokemon ->
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

//@Composable
//@Preview
//private fun HomeScreenPreview() {
//    SimplePokedexTheme {
//        HomeScreen()
//    }
//}