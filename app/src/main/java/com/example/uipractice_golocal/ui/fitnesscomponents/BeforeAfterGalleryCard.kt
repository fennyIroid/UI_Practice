package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.theme.Outfit

@Composable
fun BeforeAfterGalleryCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF252525), RoundedCornerShape(24.dp))
            .background(Color.White, RoundedCornerShape(24.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "BEFORE / AFTER GALLERY",
            letterSpacing = 1.sp,
            fontSize = 12.sp,
            fontFamily = Outfit,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            BeforeAfterImage(
                R.drawable.before_image,
                Modifier.weight(1f)
            )
            BeforeAfterImage(
                R.drawable.after_image,
                Modifier.weight(1f)
            )
        }
    }
}
