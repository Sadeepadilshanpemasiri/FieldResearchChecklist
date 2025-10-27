package com.example.fieldresearchchecklist.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val DarkColorScheme = darkColorScheme(
    primary = Teal,
    onPrimary = Cream,
    surface = DarkGrey,
    onSurface = LightGrey,
    background = DarkGrey,
    onBackground = LightGrey,
    error = ErrorRed,
    secondaryContainer = Teal
)

private val LightColorScheme = lightColorScheme(
    primary = Teal,
    onPrimary = Cream,
    surface = Cream,
    onSurface = DarkGreen,
    background = Cream,
    onBackground = DarkGreen,
    error = ErrorRed,
    secondaryContainer = LightTeal
)

@Composable
fun FieldResearchChecklistTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
