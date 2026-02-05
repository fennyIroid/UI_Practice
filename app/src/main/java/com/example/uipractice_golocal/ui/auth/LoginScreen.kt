package com.example.uipractice_golocal.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.components.AuthBottomCard
import com.example.uipractice_golocal.ui.components.LanguageDropdownChip
import com.example.uipractice_golocal.ui.components.PhoneNumberTextField
import com.example.uipractice_golocal.ui.components.PrimaryButton

@Composable
fun LoginScreen(
    onContinueClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // 🔹 Background
        Image(
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 🔹 Language chip
        LanguageDropdownChip(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 60.dp, end = 16.dp)
        )

        // 🔹 Logo
        Image(
            painter = painterResource(id = R.drawable.go_local_logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 140.dp)
                .width(140.dp)
                .aspectRatio(140f / 193.34f),
            contentScale = ContentScale.Fit
        )

        // Bottom card with natural overlap
        AuthBottomCard(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .offset(y = (-30).dp)
        ) {

            Text(
                text = "Welcome!",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1B1B1B)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Please enter your phone number to get started",
                fontSize = 14.sp,
                lineHeight = 25.sp,
                color = Color(0xFF1B1B1B).copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            PhoneNumberTextField(
                value = "",
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row {
                Text(
                    text = "By continuing, you agree to our ",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
                Text(
                    text = "Privacy Policy & Terms of Service.",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF8E9B6D)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            PrimaryButton(
                text = "Continue",
                onClick = onContinueClick
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
