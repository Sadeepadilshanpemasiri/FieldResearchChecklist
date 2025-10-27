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

// Our new color schemes that match a nature/professional theme
private val DarkColorScheme = darkColorScheme(
    primary = Teal,
    onPrimary = Cream,
    surface = DarkGrey,
    onSurface = LightGrey,
    background = DarkGrey,
    onBackground = LightGrey,
    error = ErrorRed,
    // --- ADD THIS LINE ---
    // For dark theme, let's use the main Teal as the secondary color
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
    // --- ADD THIS LINE ---
    // For light theme, we will use our LightTeal color
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
            window.statusBarColor = Color.Transparent.toArgb() // Make status bar transparent
            WindowCompat.setDecorFitsSystemWindows(window, false) // Allow content to draw behind status bar
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
