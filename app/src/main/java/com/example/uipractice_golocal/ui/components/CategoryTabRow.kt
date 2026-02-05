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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryTabRow(
    modifier: Modifier = Modifier,
    tabs: List<String> = listOf("Stores", "Products", "Professionals"),
    selectedTabIndex: Int = 1,
    onTabSelected: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            CategoryTab(
                text = tab,
                isSelected = index == selectedTabIndex,
                onClick = { onTabSelected(index) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CategoryTab(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) Color(0xFF5B6F45) else Color.White
    val contentColor = if (isSelected) Color.White else Color(0xFF1B1B1B).copy(alpha = 0.6f)
    val borderColor = if (isSelected) Color.Transparent else Color(0xFFE0E5D0)

    Box(
        modifier = modifier

            .height(39.dp)
            .width(110.dp)
            .background(backgroundColor, RoundedCornerShape(100.dp))
            .border(
                width = if (isSelected) 0.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(100.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium,
            color = contentColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryTabRowPreview() {
    androidx.compose.material3.MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            CategoryTabRow(
                selectedTabIndex = 1 // "Products" selected
            )
        }
    }
}
