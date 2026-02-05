package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpInputRow(
    otp: String,
    length: Int = 4,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(length) { index ->
            val char = otp.getOrNull(index)?.toString() ?: ""

            Text(
                text = char,
                fontSize = 18.sp,
                modifier = Modifier
                    .size(52.dp)
                    .border(
                        width = 1.dp,
                        color = if (char.isNotEmpty())
                            Color(0xFF8E9B6D)
                        else Color.Gray,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .wrapContentSize(Alignment.Center)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OtpInputRowPreview() {
    OtpInputRow(
        otp = "",
        length = 4,
        modifier = Modifier
    )
}

