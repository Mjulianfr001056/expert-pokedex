package com.example.dfm.favorite.presentation.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.library.core.presentation.home.PokedexEntry
import com.example.library.core.presentation.navigation.PokedexNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel,
    navController: NavHostController
) {
    val list = viewModel.favoritePokemon.collectAsLazyPagingItems()


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Favorite Pokémon")
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
        val loadState = list.loadState
        val isEmpty = list.itemCount == 0 && loadState.refresh is LoadState.NotLoading
        val isLoading = loadState.refresh is LoadState.Loading
        val isError = loadState.refresh is LoadState.Error

        Box(modifier = Modifier.fillMaxSize()) {
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                isError -> {
                    val error = (loadState.refresh as LoadState.Error).error
                    Text(
                        text = "Failed to load: ${error.localizedMessage}",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Red
                    )
                }

                isEmpty -> {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "No favorite Pokémon found.",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                else -> {
                    LazyColumn(contentPadding = innerPadding) {
                        items(list.itemCount) { index ->
                            val pokemon = list[index]
                            if (pokemon != null) {
                                PokedexEntry(
                                    pokemon = pokemon,
                                    onClick = {
                                        navController.navigate("detail/${pokemon.id}")
                                    }
                                )
                            }
                        }

                        when (val append = list.loadState.append) {
                            is LoadState.Loading -> {
                                item {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }
                            }

                            is LoadState.Error -> {
                                item {
                                    Text(
                                        text = "Error: ${append.error.localizedMessage}",
                                        modifier = Modifier.padding(16.dp),
                                        color = Color.Red
                                    )
                                }
                            }

                            is LoadState.NotLoading -> {
                                // No UI needed
                            }
                        }
                    }
                }
            }
        }
    }
}