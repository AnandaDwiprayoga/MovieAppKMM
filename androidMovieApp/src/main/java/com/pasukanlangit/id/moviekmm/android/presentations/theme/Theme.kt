package com.pasukanlangit.id.moviekmm.android.presentations.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("ConflictingOnColor")
private val LightThemeColors = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Black2,
    secondary = SecondaryColor,
    secondaryVariant = Teal300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = BackgroundColor,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Black2,
)

val paddingHorizontal = 16.dp
val paddingVertical = 24.dp
val overlayBrushTop = Brush.verticalGradient(
    colors = listOf(
        Color(0xC6001121),
        Color(0x41001121),
    )
)

val overlayBrushBottom = Brush.verticalGradient(
    colors = listOf(
        Color(0x41001121),
        Color(0xC6001121)
    )
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
){
    MaterialTheme(
        colors = LightThemeColors,
        shapes = AppShapes,
        typography = RobotoTypography
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            content()
        }
    }
}