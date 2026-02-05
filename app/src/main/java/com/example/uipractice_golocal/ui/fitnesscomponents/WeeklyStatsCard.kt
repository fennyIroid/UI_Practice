package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.theme.Outfit

@Composable
fun WeeklyStatsCard(
    modifier: Modifier = Modifier
) {
    // Colors matching Figma exactly
    val cardBackground = Color(0xFF252525)
    val lightGray = Color(0xFF9E9E9E)
    val white = Color.White
    
    Column(
        modifier = modifier
            .width(350.dp) // Fixed width from Figma
            .background(
                color = cardBackground,
                shape = RoundedCornerShape(28.dp) // Radius from Figma
            )
            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 18.dp), // Padding from Figma
        verticalArrangement = Arrangement.spacedBy(28.dp) // Gap from Figma
    ) {
        // Title pill - light gray, centered
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(
                    color = Color(0xFF424242), // Darker gray for title background
                    shape = RoundedCornerShape(100.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Last Week's Stats",
                color = white,
                fontSize = 12.sp,
                fontFamily = Outfit,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal
            )
        }

        // Top numbers row - larger, bolder numbers
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween // Adjusted for 350dp width
        ) {
            StatNumber(title = "Highest", value = "278")
            StatNumber(title = "Average", value = "110")
            StatNumber(title = "Goal", value = "40020")
        }

        // Bar Chart - automatically highlights the highest value
        WeeklyBarChartCanvas(
            values = listOf(42f, 120f, 8f, 22f, 80f, 20000f, 18f),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        // Footer - Calories section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_calorie),
                    contentDescription = "Calories",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Calories",
                    color = white,
                    fontSize = 14.sp,
                    fontFamily = Outfit,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            }

            Text(
                text = "568 KCAL",
                color = white,
                fontSize = 14.sp,
                fontFamily = Outfit,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
    }
}

@Composable
private fun StatNumber(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = value,
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = Outfit,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
        Text(
            text = title,
            color = Color(0xFF9E9E9E),
            fontSize = 12.sp,
            fontFamily = Outfit,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Normal
        )
    }
}



@Preview(
    showBackground = true,
    backgroundColor = 0xFF0F0F0F,
    widthDp = 360
)
@Composable
fun WeeklyStatsCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        WeeklyStatsCard()
    }
}
