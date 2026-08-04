package com.example.uipractice_golocal.ui.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.patrykandpatrick.vico.compose.common.shader.color
import com.patrykandpatrick.vico.compose.common.shape.rounded

@Composable
fun orderDetails (modifier: Modifier = Modifier) {

    OutlinedCard(
        modifier = Modifier
            .width(190.dp)
            .height(112.dp),
    ) {
        Text(
            modifier = Modifier.padding(15.dp),
            text = "Order Amount",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )

        Row() {
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "Total price",
                fontSize = 8.sp,
                fontWeight = FontWeight.Thin,

                )

            Text(
                modifier = Modifier.padding(start = 100.dp),
                text = "$30",
                fontSize = 8.sp
            )
        }

        Spacer(Modifier.height(6.dp))

        Row() {
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "Platform Fee",
                fontSize = 8.sp,
                fontWeight = FontWeight.Thin,

                )

            Text(
                modifier = Modifier.padding(start = 92.dp),
                text = "-$2",
                fontSize = 8.sp
            )
        }

        Spacer(Modifier.height(10.dp))

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(9f, 9f), 0f)
        Canvas(Modifier.width(175.dp).height(1.dp).padding(start = 13.dp)) {

            drawLine(
                color = Color.DarkGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }

        Spacer(Modifier.height(8.dp))

        Row() {
            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "Total Receivable Amount",
                fontSize = 9.sp,
                fontWeight = FontWeight.Light,

                )

            Text(
                modifier = Modifier.padding(start = 42.dp),
                text = "$28",
                fontSize = 8.sp
            )
        }
    }



}

@Preview(showBackground = true)
@Composable
fun orderDeatilsPreview() {
    orderDetails()
}