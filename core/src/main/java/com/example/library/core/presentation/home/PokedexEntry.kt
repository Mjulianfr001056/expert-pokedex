package com.example.library.core.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.library.core.domain.model.Pokemon
import com.example.library.core.presentation.TypeBadge
import com.example.library.core.util.toProperString

@Composable
fun PokedexEntry(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
    onClick : () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = pokemon.imageUrl,
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = String.format("#%03d", pokemon.id),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    ),
                    color = Color.Gray
                )
                Text(
                    text = pokemon.name.toProperString(),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
                Text(
                    text = pokemon.description,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                ) {
                    val primaryType = pokemon.primaryType
                    TypeBadge(type = primaryType)

                    pokemon.secondaryType?.let { secondaryType ->
                        TypeBadge(type = secondaryType)
                    }
                }
            }
        }
    }
}