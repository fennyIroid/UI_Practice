package com.example.uipractice_golocal.ui.skaifitness

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.ui.fitnesscomponents.MyGoalsSection
import com.example.uipractice_golocal.ui.fitnesscomponents.SkaiBottomNavigation
import com.example.uipractice_golocal.ui.fitnesscomponents.SkaiTab
import com.example.uipractice_golocal.ui.fitnesscomponents.StatCard
import com.example.uipractice_golocal.ui.fitnesscomponents.WeeklyStatsCard
import com.example.uipractice_golocal.ui.fitnesscomponents.getFitnessStats
import com.example.uipractice_golocal.ui.theme.Outfit

@Composable
fun MyProgress(
    modifier: Modifier = Modifier
) {
    val stats = getFitnessStats()
    val selectedTab = remember { mutableStateOf(SkaiTab.Progress) }
    
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            SkaiBottomNavigation(
                selectedTab = selectedTab.value,
                onTabSelected = { selectedTab.value = it }
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Screen Title
            item(span = { GridItemSpan(2) }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "My Progress",
                        fontSize = 20.sp,
                        fontFamily = Outfit,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
            
            // Weekly Stats Card
            item(span = { GridItemSpan(2) }) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WeeklyStatsCard()
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            
            // Pager-like dots
            item(span = { GridItemSpan(2) }) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(5) { index ->
                            Box(
                                modifier = Modifier
                                    .size(if (index == 2) 8.dp else 6.dp)
                                    .background(
                                        color = if (index == 2) Color.DarkGray else Color.LightGray,
                                        shape = androidx.compose.foundation.shape.CircleShape
                                    )
                            )
                        }
                    }
                }
            }
            
            // Section Header
            item(span = { GridItemSpan(2) }) {
                Column {
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "TODAY'S STATS",
                        fontSize = 14.sp,
                        fontFamily = Outfit,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
            
            // Today's Stats Grid Items
            items(stats.size) { index ->
                StatCard(
                    item = stats[index],
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Bottom spacer
            item(span = { GridItemSpan(2) }) {
                Spacer(modifier = Modifier.height(32.dp))
            }

            item(span = { GridItemSpan(2) }) {
                MyGoalsSection(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyProgressPreview() {
    MyProgress()
}
