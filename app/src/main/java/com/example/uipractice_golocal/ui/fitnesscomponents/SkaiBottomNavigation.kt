package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uipractice_golocal.R

enum class SkaiTab(val iconRes: Int, val label: String) {
    Home(R.drawable.skai_home, "Home"),
    Program(R.drawable.skai_program, "Program"),
    Progress(R.drawable.skai_progress, "Progress"),
    Community(R.drawable.skai_icons, "Community")
}

@Composable
fun SkaiBottomNavigation(
    selectedTab: SkaiTab,
    onTabSelected: (SkaiTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        shadowElevation = 16.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SkaiTab.values().forEach { tab ->
                SkaiNavigationItem(
                    tab = tab,
                    isSelected = tab == selectedTab,
                    onClick = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
private fun SkaiNavigationItem(
    tab: SkaiTab,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val activeBgColor = Color(0xFF252525)
    val activeIconColor = Color(0xFF59D6DF)
    val inactiveIconColor = Color(0xFF252525)

    Box(
        modifier = Modifier
            .size(if (isSelected) 64.dp else 48.dp)
            .background(
                color = if (isSelected) activeBgColor else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = tab.iconRes),
            contentDescription = tab.label,
            tint = if (isSelected) activeIconColor else inactiveIconColor,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Preview
@Composable
fun SkaiBottomNavigationPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.BottomCenter
    ) {
        SkaiBottomNavigation(
            selectedTab = SkaiTab.Progress,
            onTabSelected = {}
        )
    }
}
