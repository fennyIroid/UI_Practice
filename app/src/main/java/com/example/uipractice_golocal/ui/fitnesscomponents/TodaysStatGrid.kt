package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uipractice_golocal.ui.model.StatItem

@Composable
fun TodayStatsGrid(
    stats: List<StatItem>,
    modifier: Modifier = Modifier,
    onAddClick: (StatItem) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(stats.size) { index ->
            StatCard(
                item = stats[index],
                onAddClick = { onAddClick(stats[index]) }
            )
        }
    }
}


