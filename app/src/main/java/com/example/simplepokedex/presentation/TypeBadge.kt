package com.example.simplepokedex.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplepokedex.data.stub.Types
import com.example.simplepokedex.data.stub.getBadgeColor
import com.example.simplepokedex.data.stub.getTextColor
import com.example.simplepokedex.ui.theme.SimplePokedexTheme

private class TypeBadgeParamaterProvider : PreviewParameterProvider<Types> {
    override val values: Sequence<Types> = Types.entries.asSequence()
}

@Composable
fun TypeBadge(
    type: Types,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 80.dp, height = 24.dp)
            .clip(
                shape = RoundedCornerShape(8.dp)
            )
            .drawBehind {
                with(type.getBadgeColor()) {
                    drawRect(color = this.first)
                    drawRect(
                        color = this.second,
                        size = size.copy(height = size.height * 0.5f)
                    )
                }
            }
            .padding(horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = type.name,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            ),
            color = type.getTextColor(),
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
@Preview
private fun TypeBadgePreview(
    @PreviewParameter(TypeBadgeParamaterProvider::class) type: Types
) {
    SimplePokedexTheme {
        TypeBadge(type = type)
    }
}
