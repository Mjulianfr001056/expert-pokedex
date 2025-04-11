package com.example.simplepokedex.presentation.home

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.simplepokedex.presentation.navigation.PokedexNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavHostController
) {
    val list = viewModel.pokemonList.collectAsLazyPagingItems()
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

//            (list as? UiState.Success)?.data?.forEach{ pokemon ->
//                item {
//                    PokedexEntry(
//                        pokemon = pokemon,
//                        onClick = {
//                            navController.navigate("detail/${pokemon.id}")
//                        }
//                    )
//                }
//            }

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

            list.apply {
                when (loadState.append) {
                    is LoadState.Loading -> {
                        item {
                            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                        }
                    }

                    is LoadState.Error -> {
                        val error = loadState.append as LoadState.Error
                        item {
                            Text("Error: ${error.error.localizedMessage}")
                        }
                    }

                    is LoadState.NotLoading -> {

                    }
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