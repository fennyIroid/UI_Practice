package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.ui.theme.Outfit

@Composable
fun WeightHeader() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column{
            Text(
                text = "Weight",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = Outfit,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Last 90 Days",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Box(modifier = Modifier
            .size(32.dp)
            .background(Color(0xFF252525).copy(alpha =  0.18f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("+", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeightHeaderPreview() {
    WeightHeader()
}