package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R

@Composable
fun PhoneNumberTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFoucsed by interactionSource.collectIsFocusedAsState()
    val iconAlpha = if (isFoucsed || value.isNotEmpty()) 1f else 0.5f

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp),

        interactionSource = interactionSource,

        label =  {
            Text(
                text = "Phone",
                fontSize = 14.sp,
                color = Color(0xFF66754C)
            )
        },
        placeholder = {
            Text(
                text = "05XXXXXXXX",
                fontSize = 14.sp,
                color = Color.Gray
            )
        },
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_call_24),
                    contentDescription = null,
                    tint = Color(0xFF66754C).copy(alpha = iconAlpha),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(18.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "+972",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.width(4.dp))

                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = null,
                    modifier = Modifier.size(12.dp)
                )
            }
        },
        shape = RoundedCornerShape(50.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF66754C),
            unfocusedBorderColor = Color(0xFF66754C),
            cursorColor = Color(0xFF66754C)
        )
    )
}

@Preview
@Composable
fun PhoneNumberTextFieldPreview() {
    PhoneNumberTextField(
        value = "",
        onValueChange = {}
    )
}
