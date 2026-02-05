package com.example.uipractice_golocal.ui.model

data class HighlightProfile(
    val name: String,
    val imageRes: Int,
    val type: HighlightType = HighlightType.PROFILE
)
