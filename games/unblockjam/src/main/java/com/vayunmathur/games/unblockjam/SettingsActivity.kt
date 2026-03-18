package com.vayunmathur.games.unblockjam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.content.Context
import android.content.SharedPreferences
import com.vayunmathur.games.unblockjam.ui.theme.UnblockJamTheme
import com.vayunmathur.games.unblockjam.ui.theme.ThemeMap
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.core.view.WindowCompat

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val prefs: SharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val currentTheme = prefs.getString("theme_name", "default") ?: "default"
        setContent {
            UnblockJamTheme(themeName = currentTheme) {
                SettingsScreen(
                    currentTheme = currentTheme,
                    onThemeSelected = { theme ->
                        prefs.edit { putString("theme_name", theme) }
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun SettingsScreen(currentTheme: String, onThemeSelected: (String) -> Unit) {
    var selectedTheme by remember { mutableStateOf(currentTheme) }
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(Modifier.height(16.dp))
        Text("Theme")
        Column {
            ThemeMap.forEach { (themeName, _) ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedTheme == themeName,
                        onClick = {
                            selectedTheme = themeName
                            onThemeSelected(themeName)
                        }
                    )
                    Text(themeName.replaceFirstChar { it.uppercase() }, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}
