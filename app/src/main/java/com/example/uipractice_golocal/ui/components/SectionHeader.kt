package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionHeader(
    title: String,
    actionText: String? = null,
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Pill-shaped Title
        Box(
            modifier = Modifier
                .border(1.dp, Color(0xFF8E9B6D), RoundedCornerShape(100.dp))
                .background(Color(0xFFFAF4E9), RoundedCornerShape(100.dp))
                .padding(horizontal = 16.dp, vertical = 6.dp)
        ) {
             Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal, // Regular weight as per design
                color = Color(0xFF1B1B1B)
            )
        }

        // Divider Line
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color(0xFFE0E5D0))
        )
        
        // Action Text
        actionText?.let {
            Text(
                text = it,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF1B1B1B), // Dark text
                modifier = Modifier.clickable(onClick = onActionClick)
            )
        }
    }
}
