package com.example.simplepokedex.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.simplepokedex.presentation.TypeBadge
import com.example.simplepokedex.ui.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailViewModel,
    id: Int
) {

    LaunchedEffect(true) {
        viewModel.loadPokemon(id)
    }

    val uiState by viewModel.pokemon.collectAsStateWithLifecycle()
    val pokemon = (uiState as? UiState.Success)?.data
    val isFavorite by viewModel.isFavorite.collectAsStateWithLifecycle()

//    val pokemon: Pokemon? = Pokemon(
//        id = 1,
//        name = "Bulbasaur",
//        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
//        description = "For some time after its birth, it grows by gaining nourishment from the seed on its back.",
//        primaryType = Types.GRASS,
//        secondaryType = Types.POISON,
//        weaknesses = listOf(Types.FLYING, Types.PSYCHIC),
//        height = "0.7 m",
//        weight = "6.9 kg",
//        category = "Seed",
//        abilities = "Overgrow",
//        abilitiesDescription = "Powers up Grass-type moves when the Pokémon's HP is low.",
//        isFavorite = false
//    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pokemon Detail",
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .verticalScroll(
                    rememberScrollState(0)
                )
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = pokemon?.name ?: "",
                    style = MaterialTheme.typography.displaySmall
                )

                Text(
                    text = String.format("#%03d", pokemon?.id ?: 0),
                    style = MaterialTheme.typography.displaySmall.copy(
                        color = MaterialTheme.colorScheme.secondary
                    )

                )
            }

            AsyncImage(
                model = pokemon?.imageUrl ?: "",
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            if (isFavorite) {
                Button(
                    shape = RoundedCornerShape(24.dp),
                    onClick = {
                        pokemon?.let {
                            viewModel.removeFromFavorite(it)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite"
                        )
                        Text(
                            text = "Remove from favorite",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                }
            } else {
                Button(
                    shape = RoundedCornerShape(24.dp),
                    onClick = {
                        pokemon?.let {
                            viewModel.saveToFavorite(it)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                        Text(
                            text = "Mark as favorite",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                }
            }

            Text(
                text = pokemon?.description ?: "",
                style = MaterialTheme.typography.bodyLarge
            )

            Card(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                    ),
                colors = CardDefaults.cardColors().copy(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(0.4f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Height",
                                style = MaterialTheme.typography.bodyLarge
                                    .copy(
                                        fontWeight = FontWeight(500)
                                    ),
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )

                            Text(
                                text = pokemon?.height ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Weight",
                                style = MaterialTheme.typography.bodyLarge
                                    .copy(
                                        fontWeight = FontWeight(500)
                                    ),
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )

                            Text(
                                text = pokemon?.weight ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(0.6f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Category",
                                style = MaterialTheme.typography.bodyLarge
                                    .copy(
                                        fontWeight = FontWeight(500)
                                    ),
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )

                            Text(
                                text = pokemon?.category ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Abilities",
                                style = MaterialTheme.typography.bodyLarge
                                    .copy(
                                        fontWeight = FontWeight(500)
                                    ),
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )

                            Text(
                                text = pokemon?.abilities ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(0.5f)
                            )
                        }
                    }

                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Abilities",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight(600)
                    )
                )

                Text(
                    text = pokemon?.abilitiesDescription ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Type",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight(600)
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    pokemon?.primaryType?.let { primaryType ->
                        TypeBadge(type = primaryType)
                    }

                    pokemon?.secondaryType?.let { secondaryType ->
                        TypeBadge(type = secondaryType)
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Weaknesses",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight(600)
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    pokemon?.weaknesses?.forEach { weakness ->
                        TypeBadge(type = weakness)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun DetailScreenPreview(modifier: Modifier = Modifier) {
//    DetailScreen(
//        navController = rememberNavController(),
//        viewModel = null,
//        id = 1
//    )
}