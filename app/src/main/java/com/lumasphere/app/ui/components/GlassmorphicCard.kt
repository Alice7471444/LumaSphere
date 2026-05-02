package com.lumasphere.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lumasphere.app.ui.theme.PurplePrimary
import com.lumasphere.app.ui.theme.SurfaceGlass
import com.lumasphere.app.ui.theme.SurfaceGlassVariant

@Composable
fun GlassmorphicCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    backgroundOpacity: Float = 0.1f,
    borderOpacity: Float = 0.2f,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(cornerRadius),
                ambientColor = PurplePrimary.copy(alpha = 0.1f),
                spotColor = PurplePrimary.copy(alpha = 0.1f)
            )
            .clip(RoundedCornerShape(cornerRadius))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        SurfaceGlass.copy(alpha = backgroundOpacity),
                        SurfaceGlassVariant.copy(alpha = backgroundOpacity * 0.8f)
                    )
                )
            )
            .padding(1.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = borderOpacity),
                        Color.Transparent
                    )
                ),
                shape = RoundedCornerShape(cornerRadius)
            )
            .clip(RoundedCornerShape(cornerRadius))
            .background(SurfaceGlass.copy(alpha = backgroundOpacity))
    ) {
        content()
    }
}