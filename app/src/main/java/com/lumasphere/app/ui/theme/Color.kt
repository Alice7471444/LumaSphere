package com.lumasphere.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Glassmorphism Colors - Futuristic Theme
val PurplePrimary = Color(0xFF8B5CF6)
val PurpleSecondary = Color(0xFFA78BFA)
val PurpleDark = Color(0xFF6D28D9)
val CyanAccent = Color(0xFF22D3EE)
val PinkAccent = Color(0xFFEC4899)

// Background Colors
val BackgroundDark = Color(0xFF0F0F1A)
val SurfaceDark = Color(0xFF1A1A2E)
val SurfaceGlass = Color(0xFF1E1E3F)
val SurfaceGlassVariant = Color(0xFF252547)

// Text Colors
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFFA1A1AA)
val TextTertiary = Color(0xFF71717A)

// Status Colors
val Success = Color(0xFF10B981)
val Error = Color(0xFFEF4444)
val Warning = Color(0xFFF59E0B)

private val DarkColorScheme = darkColorScheme(
    primary = PurplePrimary,
    secondary = CyanAccent,
    tertiary = PinkAccent,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = TextPrimary,
    onSecondary = TextPrimary,
    onTertiary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    error = Error,
    onError = TextPrimary
)

@Composable
fun LumaSphereTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}