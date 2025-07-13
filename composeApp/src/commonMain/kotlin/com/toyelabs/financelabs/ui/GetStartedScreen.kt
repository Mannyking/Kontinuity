package com.toyelabs.financelabs.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.theme.dotoFontFamily
import financelabs.composeapp.generated.resources.Res
import financelabs.composeapp.generated.resources.ic_hourglass
import financelabs.composeapp.generated.resources.ic_stopwatch
import financelabs.composeapp.generated.resources.ic_wallet
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GetStartedScreen(onGetStarted: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(Res.drawable.ic_wallet),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .graphicsLayer{
                        rotationZ = -60f
                    }
                    .offset(x = (30).dp, y = (-140).dp)
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .alpha(0.2f)
            )

            Image(
                painter = painterResource(Res.drawable.ic_hourglass),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .graphicsLayer{
                        rotationZ = 30f
                    }
                    .offset(x = 100.dp, y = (-40).dp)
                    .align(Alignment.CenterEnd)
                    .padding(16.dp)
                    .alpha(0.3f)
            )

            Image(
                painter = painterResource(Res.drawable.ic_stopwatch),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer{
                        rotationZ = -20f
                    }
                    .offset(x = (-70).dp, y = 40.dp)
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
                    .alpha(0.15f)

            )

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

                Column(
                    modifier = Modifier.padding(bottom = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = onGetStarted,
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(size = 8.dp)
                    ) {
                        Text("Get Started")
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = buildAnnotatedString {
                            append("Already have an account? ")
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append("Login") }
                        },
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraLight
                        )
                    )
                }
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