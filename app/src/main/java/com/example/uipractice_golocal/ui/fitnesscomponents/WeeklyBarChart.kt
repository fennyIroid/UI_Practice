package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.ui.theme.Outfit
import kotlin.math.max
import kotlin.math.pow


/**
 * Custom Canvas-based Weekly Bar Chart matching Figma design exactly.
 */
@Composable
fun WeeklyBarChartCanvas(
    values: List<Float>,
    modifier: Modifier = Modifier
) {
    if (values.isEmpty() || values.size != 7) return

    // Find the index of the highest value to highlight
    val maxIndex = remember(values) {
        val maxVal = values.maxOrNull() ?: -1f
        values.indexOf(maxVal)
    }

    // Colors matching Figma
    val darkBarColor = Color(0xFF326369) // Dark teal for regular bars
    val highlightBarColor = Color(0xFF59D6DF) // Bright cyan for highlighted bar
    val bubbleWhite = Color.White
    val textColorDark = Color(0xFF1E1E1E)
    val textColorWhite = Color.White

    // Days and months for labels
    val days = listOf("01", "02", "03", "04", "05", "06", "07")
    val months = listOf("NOV", "NOV", "NOV", "NOV", "NOV", "NOV", "NOV")

    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // ───── Dimensions ─────
        val barWidth = 22.dp.toPx()
        val barSpacing = 20.dp.toPx()
        val labelAreaHeight = 40.dp.toPx() // Space for labels at bottom
        val topPadding = 12.dp.toPx() // Padding for bubbles
        val chartAreaHeight = canvasHeight - labelAreaHeight - topPadding

        // Calculate total width and starting X to center the chart
        val totalBarsWidth = (barWidth * 7) + (barSpacing * 6)
        val startX = (canvasWidth - totalBarsWidth) / 2f

        // Rounding for full pill shape
        val cornerRadius = barWidth / 2f

        // ───── Scaling Logic ─────
        // We use a power scale (square root) to ensure small values remain visible
        // even when a massive outlier (like 20000) exists.
        val maxValue = values.maxOrNull() ?: 1f
        
        values.forEachIndexed { index, value ->
            val isHighlighted = index == maxIndex
            
            // Calculate bar position
            val barX = startX + (index * (barWidth + barSpacing))
            val barBottomY = canvasHeight - labelAreaHeight

            // Scaling: Power scale (exponent 0.5) lifts smaller values visually
            val normalizedValue = if (maxValue > 0) {
                (value / maxValue).pow(0.5f)
            } else 0f


            // Apply minimum visibility (25% of chart area) for non-zero values
            val barHeight = if (value > 0) {
                max(
                    chartAreaHeight * 0.25f,
                    normalizedValue * chartAreaHeight
                )
            } else 4.dp.toPx()

            val barTopY = barBottomY - barHeight

            // ───── Draw Full Pill Bar ─────
            drawRoundRect(
                color = if (isHighlighted) highlightBarColor else darkBarColor,
                topLeft = Offset(barX, barTopY),
                size = Size(barWidth, barHeight),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadius, cornerRadius)
            )

            // ───── Draw Bubble INSIDE the Bar ─────
            val valueText = if (value >= 1000) "${(value / 1000).toInt()}k" else value.toInt().toString()
            val bubbleRadius = (barWidth - 4.dp.toPx()) / 2f
            val bubbleSize = bubbleRadius * 2
            
            val bubbleX = barX + (barWidth - bubbleSize) / 2f
            val bubbleY = barTopY + 2.dp.toPx()

            val bubbleBgColor = if (isHighlighted) bubbleWhite else highlightBarColor
            val bubbleTextColor = if (isHighlighted) textColorDark else textColorWhite

            drawRoundRect(
                color = bubbleBgColor,
                topLeft = Offset(bubbleX, bubbleY),
                size = Size(bubbleSize, bubbleSize),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(bubbleRadius, bubbleRadius)
            )

            // Draw text inside bubble
            drawContext.canvas.nativeCanvas.apply {
                val paint = android.graphics.Paint().apply {
                    color = bubbleTextColor.hashCode()
                    textSize = 7.sp.toPx()
                    textAlign = android.graphics.Paint.Align.CENTER
                    isAntiAlias = true
                    typeface = android.graphics.Typeface.create("Outfit", android.graphics.Typeface.BOLD)
                }
                
                val textY = bubbleY + (bubbleSize / 2f) + (paint.textSize / 3f)
                drawText(
                    valueText,
                    barX + (barWidth / 2f),
                    textY,
                    paint
                )
            }

            // ───── Draw Label ─────
            val labelStartY = canvasHeight - labelAreaHeight + 16.dp.toPx()
            val labelCenterX = barX + (barWidth / 2f)

            // Day
            drawContext.canvas.nativeCanvas.apply {
                val paint = android.graphics.Paint().apply {
                    color = Color.White.hashCode()
                    textSize = 10.sp.toPx()
                    textAlign = android.graphics.Paint.Align.CENTER
                    isAntiAlias = true
                    typeface = android.graphics.Typeface.create("Outfit", android.graphics.Typeface.BOLD)
                }
                drawText(days[index], labelCenterX, labelStartY, paint)
                
                // Month (secondary text)
                paint.textSize = 8.sp.toPx()
                paint.typeface = android.graphics.Typeface.DEFAULT
                drawText(months[index], labelCenterX, labelStartY + 12.dp.toPx(), paint)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeeklyBarChartCanvasPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(Color(0xFF1E1E1E))
            .padding(16.dp)
    ) {
        WeeklyBarChartCanvas(
            values = listOf(42f, 120f, 8f, 22f, 80f, 200f, 18f),
            modifier = Modifier.fillMaxSize()
        )
    }
}
