package com.toyelabs.financelabs.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.theme.dotoFontFamily
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LaunchScreen(onFinished: () -> Unit) {
    val visible = remember { mutableStateOf(false) }

    val alpha by animateFloatAsState(
        targetValue = if(visible.value) 1f else 0f,
        animationSpec = tween(durationMillis = 1200),
        label = "fade-in"
    )
    val offsetY by animateFloatAsState(
        targetValue = if (visible.value) 0f else 40f,
        animationSpec = tween(durationMillis = 800),
        label = "slide-up"
    )

    LaunchedEffect(Unit) {
        visible.value = true
        delay(1800)
        onFinished()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Finance ")
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) { append("Labs") }
                },
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp,
                    fontFamily = dotoFontFamily()
                ),
                modifier = Modifier
                    .alpha(alpha)
                    .offset(y = offsetY.dp),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Stay connected to your Nigerian life",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.secondary,
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview()
@Composable
fun LaunchScreenPreview() {
    FinanceLabsTheme(useDarkTheme = true) {
        LaunchScreen { }
    }
}
