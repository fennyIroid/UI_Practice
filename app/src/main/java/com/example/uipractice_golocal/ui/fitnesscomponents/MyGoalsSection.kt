package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MyGoalsSection(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        MyGoalsHeader()

        MyGoalsCardContainer {
            WeightHeader()
            WeightStatRow()
            BeforeAfterGalleryCard()
        }
    }
}

