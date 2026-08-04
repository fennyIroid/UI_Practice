package com.example.uipractice_golocal.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.components.*

@Composable
fun OtpScreen(
    onVerifyClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    var otp by remember { mutableStateOf("") }
    var focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }


    Box(modifier = Modifier.fillMaxSize()) {

        // 🔹 Background
        Image(
            painter = painterResource(R.drawable.banner),
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
            painter = painterResource(R.drawable.ic_mobile),
            contentDescription = "App Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 140.dp)
                .width(140.dp)
                .aspectRatio(140f / 193.34f),
            contentScale = ContentScale.Fit
        )

        // 🔹 Bottom card
        AuthBottomCard(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
        ) {

            Text(
                text = "Verify",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1B1B1B)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Please enter the OTP that we have sent to your number\n" +
                        "********14",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color(0xFF1B1B1B).copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            BasicTextField(
                value = otp,
                onValueChange = {
                    if (it.length <= 4 && it.all(Char::isDigit)) {
                        otp = it
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                ),
                modifier = Modifier
                    .size(1.dp) // invisible but active
                    .focusRequester(focusRequester)
            )

            OtpInputRow(otp = otp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable{
                        focusRequester.requestFocus()
                    }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "00:30   Resend",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            PrimaryButton(
                text = "Verify",
                onClick = onVerifyClick,
                enabled = otp.length == 4
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Back",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable{ onBackClick() }
            )
        }
    }
}

@Preview(
    name = "OTP Screen",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,dpi=420"
)
@Composable
fun OtpScreenPreview() {
    OtpScreen()
}
