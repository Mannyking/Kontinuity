package com.toyelabs.financelabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.ui.GetStartedScreen
import com.toyelabs.financelabs.ui.LaunchScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed class Screen {
    object Launch: Screen()
    object GetStarted: Screen()
}

@Composable
@Preview
fun App() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Launch) }

    FinanceLabsTheme {
        when (currentScreen) {
            Screen.Launch -> LaunchScreen { currentScreen = Screen.GetStarted }
            Screen.GetStarted -> GetStartedScreen { }
        }
    }
}
