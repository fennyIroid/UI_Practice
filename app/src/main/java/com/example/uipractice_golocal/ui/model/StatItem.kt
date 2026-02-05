package com.example.uipractice_golocal.ui.model

import androidx.compose.ui.graphics.painter.Painter

data class StatItem(
    val title: String,
    val valueText: String,
    val goalText: String,
    val progress: Float,
    val icon: Painter
)
