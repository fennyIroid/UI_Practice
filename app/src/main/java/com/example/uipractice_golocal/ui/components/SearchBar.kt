package com.example.uipractice_golocal.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    placeholder: String = "Search for Products",
    onSearchClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .width(225.dp)
            .height(44.dp)
            .background(
                color = Color(0xFFF4F3EF),
                shape = RoundedCornerShape(100.dp)
            )
            .border(1.dp, Color(0xFF8E9B6D), RoundedCornerShape(100.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = placeholder,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF9E9E9E),
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_mobile),
            contentDescription = "Search",
            tint = Color(0xFF8E9B6D),
            modifier = Modifier.size(20.dp)
        )
    }
}
