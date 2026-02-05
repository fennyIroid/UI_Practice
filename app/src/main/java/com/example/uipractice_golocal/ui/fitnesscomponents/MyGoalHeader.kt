package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.ui.theme.Outfit

@Composable
fun MyGoalsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "MY GOALS",
            letterSpacing = 1.sp,
            fontSize = 14.sp,
            fontFamily = Outfit,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF252525)
        )

        Text(
            text = "ALL >",
            fontSize = 14.sp,
            fontFamily = Outfit,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF252525)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyGoalsHeaderPreview() {
    MyGoalsHeader()
}