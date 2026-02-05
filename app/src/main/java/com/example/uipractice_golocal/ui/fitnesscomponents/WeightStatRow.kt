package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeightStatRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        WeightStatTile(
            value = "145",
            unit = "LBS",
            label = "Your Goal",
            modifier = Modifier.weight(1f)
        )

        WeightStatTile(
            value = "24",
            unit = "LBS",
            label = "Weight Loss",
            modifier = Modifier.weight(1f)
        )
    }
}