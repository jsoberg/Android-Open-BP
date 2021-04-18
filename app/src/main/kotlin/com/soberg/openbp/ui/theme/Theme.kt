package com.soberg.openbp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Cyan700,
    primaryVariant = Cyan900,
    onPrimary = Color.White,
    secondary = Cyan700,
    secondaryVariant = Cyan900,
    onSecondary = Color.White,
    error = Cyan800
)

private val DarkThemeColors = darkColors(
    primary = Cyan300,
    primaryVariant = Cyan700,
    onPrimary = Color.Black,
    secondary = Cyan300,
    onSecondary = Color.Black,
    error = Cyan200
)

@Composable
fun OpenBpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        content = content
    )
}
