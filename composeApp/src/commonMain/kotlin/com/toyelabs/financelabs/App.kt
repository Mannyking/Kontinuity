package com.toyelabs.financelabs

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.ui.GetStartedScreen
import com.toyelabs.financelabs.ui.LaunchScreen
import com.toyelabs.financelabs.ui.LoginScreen
import com.toyelabs.financelabs.ui.onboarding.OnboardingScreen
import com.toyelabs.financelabs.ui.onboarding.PreOnboardingScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    FinanceLabsTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "launch",
            enterTransition = { fadeIn(tween(100)) },
            exitTransition = { fadeOut(tween(10)) },
            popEnterTransition = { fadeIn(tween(100)) },
            popExitTransition = { fadeOut(tween(10)) },
        ) {
            composable("launch") {
                LaunchScreen { navController.navigate("get_started") }
            }
            composable("get_started") {
                GetStartedScreen(
                    onGetStarted = { navController.navigate("pre_onboarding") },
                    onLoginClick = { navController.navigate("login") })
            }
            composable("login") {
                LoginScreen(onGetStartedClick = { navController.navigate("pre_onboarding") })
            }
            composable("onboarding") {
                OnboardingScreen(onConfirmClick = { navController.navigate("get_started") })
            }
            composable("pre_onboarding") {
                PreOnboardingScreen(onConfirmClick = { navController.navigate("onboarding") })
            }
        }
    }
}
