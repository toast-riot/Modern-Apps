package com.vayunmathur.games.unblockjam.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DefaultColorScheme = darkColorScheme(
    primary = DarkBrown,
    secondary = Brown,
    tertiary = Tan,
    background = Brown,
    surface = DarkBrown,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    primaryContainer = Orange,
    error = Color.Red
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFF90CAF9),
    tertiary = Color(0xFFB3E5FC),
    background = Color(0xFFE3F2FD),
    surface = Color(0xFFBBDEFB),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    primaryContainer = Color(0xFF1976D2),
    secondaryContainer = Color(0xFF64B5F6),
    error = Color.Red
)

val ThemeMap: Map<String, ColorScheme> = mapOf(
    "default" to DefaultColorScheme,
    "light" to LightColorScheme
)

@Composable
fun UnblockJamTheme(
    themeName: String = "default",
    content: @Composable () -> Unit
) {
    val colorScheme = ThemeMap[themeName] ?: DefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}