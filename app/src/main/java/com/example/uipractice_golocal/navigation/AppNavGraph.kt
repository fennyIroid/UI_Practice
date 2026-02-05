package com.example.uipractice_golocal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uipractice_golocal.ui.auth.LoginScreen
import com.example.uipractice_golocal.ui.auth.OtpScreen
import com.example.uipractice_golocal.ui.auth.SplashScreen
import com.example.uipractice_golocal.ui.auth.WelcomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onNext = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onContinueClick = {
                    navController.navigate(Routes.OTP) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.OTP) {
            OtpScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onVerifyClick = {
                    navController.navigate(Routes.WELCOME) {
                        popUpTo(Routes.OTP) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.WELCOME){
            WelcomeScreen(
                onContinueClickHome = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.WELCOME) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            com.example.uipractice_golocal.ui.home.HomeScreen()
        }
    }
}