package com.example.uipractice_golocal.ui.fitnesscomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.model.StatItem
import com.example.uipractice_golocal.ui.theme.Outfit

@Composable
fun StatCard(
    item: StatItem,
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFF1E1E1E),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(14.dp)
    ) {

        // + button (overlay)
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(26.dp)
                .background(Color(0xFF2A2A2A), CircleShape)
                .clickable { onAddClick() },
            contentAlignment = Alignment.Center
        ) {
            Text("+", color = Color.White, fontSize = 16.sp, fontFamily = Outfit)
        }

        // MAIN CONTENT ROW
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)

        ) {
            // Progress background plate
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.03f),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                RoundedSquareProgress(
                    valueText = item.valueText,
                    goalText = item.goalText,
                    progress = item.progress,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Icon + text (STAYS CENTERED)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = item.icon,
                    contentDescription = item.title,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = Outfit
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun StatCardPreview() {
    StatCard(
        item = StatItem(
            title = "Steps",
            valueText = "820",
            goalText = "/5000",
            progress = 0.16f,
            icon = painterResource(id = R.drawable.ic_steps)
        ),
        modifier = Modifier
            .width(170.dp)
            .height(120.dp)
    )
}
