package com.example.simplepokedex.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.simplepokedex.presentation.navigation.PokedexNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController
) {
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
        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 32.dp)
        ) {
            AsyncImage(
                model = "https://avatars.githubusercontent.com/u/102880987?v=4",
                contentDescription = "avatar",
                clipToBounds = true,
                modifier = Modifier.padding(16.dp)
                    .clip(CircleShape)
                    .size(250.dp)
            )

            Text(
                text = "Muhammad Julian Firdaus",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "25julianfirdaus@gmail.com",
                style = MaterialTheme.typography.titleMedium
                    .copy(
                        color = MaterialTheme.colorScheme.secondary
                    ),
            )
        }
    }
}

//@Composable
//@Preview
//fun ProfileScreenPreview() {
//    ProfileScreen()
//}