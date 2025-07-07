package com.toyelabs.financelabs

import androidx.compose.runtime.Composable
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.ui.LaunchScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    FinanceLabsTheme {
        LaunchScreen()
    }
}
