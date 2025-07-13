package com.toyelabs.financelabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Text(
                "Hi Claire!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium.copy()
            )
            Text(
                "Let's get you in",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.secondary,
                )
            )

            TextField("Wallet ID", onValueChange = {})
            TextField("Password", onValueChange = {})
        }
    }
}

@Preview()
@Composable
fun LoginScreenPreview() {
    FinanceLabsTheme {
        LoginScreen()
    }
}