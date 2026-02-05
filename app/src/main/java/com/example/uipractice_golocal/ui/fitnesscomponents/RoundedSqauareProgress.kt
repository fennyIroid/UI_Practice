package com.example.uipractice_golocal.ui.fitnesscomponents


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.uipractice_golocal.ui.theme.Outfit
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedSquareProgress(
    valueText: String,
    goalText: String,
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 1.5.dp,
    cornerRadius: Dp = 14.dp,
    trackColor: Color = Color(0xFF2C2C2C),
    progressColor: Color = Color(0xFF59D6DF)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        // 1️⃣ Draw ring (always full size)
        Canvas(modifier = Modifier.fillMaxSize()) {

            val strokePx = strokeWidth.toPx()
            val inset = strokePx / 2

            val rect = Rect(
                inset,
                inset,
                size.width - inset,
                size.height - inset
            )

            val path = Path().apply {
                addRoundRect(
                    RoundRect(
                        rect, cornerRadius.toPx(), cornerRadius.toPx()
                    )
                )
            }

            val pathMeasure = PathMeasure().apply {
                setPath(path, false)
            }

            val stroke = Stroke(strokePx, cap = StrokeCap.Round)

            // Track
            drawPath(
                path = path,
                color = trackColor.copy(alpha = 0.25f),
                style = stroke
            )

            // Progress
            val progressPath = Path()
            pathMeasure.getSegment(
                0f,
                pathMeasure.length * progress.coerceIn(0f, 1f),
                progressPath,
                true
            )

            drawPath(
                path = progressPath,
                brush = Brush.sweepGradient(
                    listOf(
                        progressColor.copy(alpha = 0.4f),
                        progressColor,
                        progressColor.copy(alpha = 0.9f)
                    )
                ),
                style = stroke
            )
        }

        // 2️⃣ SAFE inner content area (this is the fix)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp), // reserves space from ring
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = valueText,
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = Outfit,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = goalText,
                fontSize = 10.sp,
                color = Color.Gray,
                fontFamily = Outfit,
                maxLines = 1
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RoundedSquareProgressPreview() {
    RoundedSquareProgress(
        valueText = "820",
        goalText = "/5000",
        progress = 0.16f,
        modifier = Modifier.size(56.dp)
    )
}
