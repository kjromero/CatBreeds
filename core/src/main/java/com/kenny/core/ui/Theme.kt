package com.kenny.core.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightThemeColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    onPrimary = OnPrimary,
    secondary = Secondary,
    secondaryVariant = SecondaryVariant,
    onSecondary = OnSecondary,
    error = Error,
    onBackground = OnBackground,
    background = Background,
    surface = Surface,
    onSurface = OnSurface,
    onError = OnError,
)

@Composable
fun CatBreedsTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightThemeColors,
        content = content
    )
}