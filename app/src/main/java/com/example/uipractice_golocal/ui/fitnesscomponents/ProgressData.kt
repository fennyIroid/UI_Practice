package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.model.StatItem

@Composable
fun getFitnessStats(): List<StatItem> {
    return listOf(
        StatItem(
            title = "Steps",
            valueText = "820",
            goalText = "/5000",
            progress = 0.16f,
            icon = painterResource(id = R.drawable.ic_steps)
        ),
        StatItem(
            title = "Exercise",
            valueText = "12:10",
            goalText = "/18 hrs",
            progress = 0.67f,
            icon = painterResource(id = R.drawable.ic_exercise)
        ),
        StatItem(
            title = "Calories",
            valueText = "68",
            goalText = "kcal",
            progress = 0.42f,
            icon = painterResource(id = R.drawable.ic_calorie)
        ),
        StatItem(
            title = "Water",
            valueText = "4",
            goalText = "/10 fl oz",
            progress = 0.4f,
            icon = painterResource(id = R.drawable.ic_water)
        ),
        StatItem(
            title = "Sleep",
            valueText = "6",
            goalText = "/7 hrs",
            progress = 0.85f,
            icon = painterResource(id = R.drawable.ic_sleep)
        ),
        StatItem(
            title = "Protein",
            valueText = "18",
            goalText = "/80 g",
            progress = 0.22f,
            icon = painterResource(id = R.drawable.ic_protien)
        )
    )
}

@Composable
fun ProgressScreen() {
    TodayStatsGrid(stats = getFitnessStats())
}


@Composable
@Preview(showBackground = true)
fun ProgressScreenPreview() {
    ProgressScreen()
}
