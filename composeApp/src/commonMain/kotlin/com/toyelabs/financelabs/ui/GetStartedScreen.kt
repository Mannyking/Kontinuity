package com.toyelabs.financelabs.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.theme.dotoFontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GetStartedScreen(onGetStarted: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Finance Labs",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = dotoFontFamily()
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))


            }

            Button(
                onClick = onGetStarted,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp),
                shape = RoundedCornerShape(size = 8.dp)
            ) {
                Text("Get Started")
            }
        }
    }
}

@Preview
@Composable
fun GetStartedScreenPreview() {
    FinanceLabsTheme {
        GetStartedScreen( onGetStarted = { TODO() })
    }
}