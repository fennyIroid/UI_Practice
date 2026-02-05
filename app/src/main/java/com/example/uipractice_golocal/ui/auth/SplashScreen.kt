package com.example.uipractice_golocal.ui.auth

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uipractice_golocal.R
import com.example.uipractice_golocal.ui.fitnesscomponents.WeeklyStatsCard
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNext: () -> Unit = {}) {

    LaunchedEffect(Unit) {
        delay(2000)
        onNext()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.go_local_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.go_local_logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .width(162.dp)
                .aspectRatio(161.75f / 223.87f),
            contentScale = ContentScale.Fit
        )

        WeeklyStatsCard()

    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}