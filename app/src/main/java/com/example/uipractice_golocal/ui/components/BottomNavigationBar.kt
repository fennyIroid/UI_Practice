package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.tooling.preview.Preview
import com.example.uipractice_golocal.R

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {}
) {
    val items = listOf(
        BottomNavItem("Home", R.drawable.ic_home),
        BottomNavItem("Videos", R.drawable.ic_video_play), 
        BottomNavItem("Cart", R.drawable.ic_shopping_cart),
        BottomNavItem("Profile", R.drawable.ic_profile_circle)
    )

    Box(
        modifier = modifier
            .padding(bottom = 30.dp, start = 16.dp, end = 16.dp) // Floating margin
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp) // Taller for the floating look
                .background(Color(0xFFF9FAEF), RoundedCornerShape(percent = 50)) // Pill shape
                .border(1.dp, Color(0xFFE0E5D0), RoundedCornerShape(percent = 50))
                .clip(RoundedCornerShape(percent = 50))
                .padding(horizontal = 24.dp), // Check spacing
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex

                val backgroundColor = if (isSelected) Color(0xFF5B6F45) else Color.Transparent
                val iconColor = if (isSelected) Color.White else Color(0xFF8E9B6D)

                Box(
                    modifier = Modifier
                        .height(40.dp)                              // 👈 thinner pill
                        .width(if (isSelected) 82.dp else 40.dp)    // 👈 capsule proportion
                        .clip(RoundedCornerShape(100.dp))
                        .background(backgroundColor)
                        .clickable { onItemSelected(index) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = item.label,
                        tint = iconColor,
                        modifier = Modifier.size(20.dp)              // 👈 slightly smaller icon
                    )
                }
            }

        }
    }
}

data class BottomNavItem(
    val label: String,
    val iconResId: Int
)

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    androidx.compose.material3.MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 25.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomNavigationBar(
                selectedIndex = 0
            )
        }
    }
}
