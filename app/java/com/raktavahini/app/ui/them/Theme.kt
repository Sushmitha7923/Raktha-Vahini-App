package com.raktavahini.app.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = RedPrimary,
    secondary = DarkRed,
    background = White,
    surface = White
)

@Composable
fun RaktaVahiniTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}