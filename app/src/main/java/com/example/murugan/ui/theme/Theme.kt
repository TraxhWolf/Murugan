package com.example.murugan.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MuruganTheme(
    content: @Composable () -> Unit
) {
    // Define your hardcoded color scheme here
    val fixedColorScheme = lightColorScheme(
        primary = Color.Red,  // Replace with your desired primary color
        secondary = Color.Green,  // Replace with your desired secondary color
        tertiary = Color.Blue  // Replace with your desired tertiary color
        // Add other color overrides as needed
    )

    // Apply the hardcoded color scheme
    MaterialTheme(
        colorScheme = fixedColorScheme,
        typography = Typography,
        content = content
    )
}
