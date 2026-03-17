package com.vayunmathur.games.unblockjam.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CustomDarkColorScheme = darkColorScheme(
    primary = Ashen_background,
    secondary = Color.Green,
    tertiary = Color.Magenta,
    background = Ashen_g_9,
    surface = Ashen_background,
    onPrimary = Ashen_g_2,
    onSecondary = Ashen_g_2,
    onTertiary = Ashen_g_2,
    onBackground = Ashen_g_2,
    onSurface = Ashen_g_2,
    primaryContainer = Ashen_orange_glow,
    error = Ashen_red_flame,
)

//background: g_9
//main block: red_ember
//secondary block: orange_blaze
//play area, surfaces: background

@Composable
fun UnblockJamTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = CustomDarkColorScheme,
        typography = Typography,
        content = content
    )
}