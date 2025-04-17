package com.example.library.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val OrangePokedexTheme = lightColorScheme(
    primary = Color(0xFFFF6F00),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFCC80),
    onPrimaryContainer = Color(0xFF3E2723),

    secondary = Color(0xFFF57C00),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFFD180),
    onSecondaryContainer = Color(0xFF4E342E),

    background = Color(0xFFFFF3E0),
    onBackground = Color(0xFF3E2723),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF212121),

    error = Color(0xFFD32F2F),
    onError = Color(0xFFFFFFFF)
)

val OrangePokedexDarkTheme = darkColorScheme(
    primary = Color(0xFFFF9100),
    onPrimary = Color(0xFF3E2723),
    primaryContainer = Color(0xFF3E2723),
    onPrimaryContainer = Color(0xFFFFAB40),

    secondary = Color(0xFFFFB74D),
    onSecondary = Color(0xFF212121),
    secondaryContainer = Color(0xFF5D4037),
    onSecondaryContainer = Color(0xFFFFD180),

    background = Color(0xFF121212),
    onBackground = Color(0xFFFFE0B2),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFFFCC80),

    error = Color(0xFFEF5350),
    onError = Color(0xFFFFFFFF)
)



@Composable
fun SimplePokedexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> OrangePokedexDarkTheme
        else -> OrangePokedexTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}