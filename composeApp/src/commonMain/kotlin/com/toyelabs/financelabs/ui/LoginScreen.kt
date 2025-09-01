package com.toyelabs.financelabs.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.toyelabs.financelabs.theme.BurntOrange500
import com.toyelabs.financelabs.theme.FinanceLabsTheme
import com.toyelabs.financelabs.theme.NavyBlue500
import com.toyelabs.financelabs.theme.Orange500
import com.toyelabs.financelabs.theme.Purple500
import com.toyelabs.financelabs.theme.TurquoiseBlue500
import com.toyelabs.financelabs.theme.White
import financelabs.composeapp.generated.resources.Res
import financelabs.composeapp.generated.resources.biometric
import financelabs.composeapp.generated.resources.face_id
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = { },
    onGetStartedClick: () -> Unit = { }
) {
    var walletId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val iconSize = 64.dp
    val name = "Mama"

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .padding(top = 24.dp, bottom = 44.dp, start = 24.dp, end = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(180.dp))

            Row {
                Text(
                    text = "Hi ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge.copy()
                )

                RainbowText(
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                    text = "$name!"
                )
            }

            Text(
                "Let's get you in",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.secondary,
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp),
                shape = RoundedCornerShape(size = 12.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.background.copy(alpha = 1f),
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                ) {
                    OutlinedTextField(
                        value = walletId,
                        onValueChange = { walletId = it },
                        label = { Text("Wallet ID") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(size = 12.dp),
                        colors = OutlinedTextFieldDefaults.colors()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(size = 12.dp),
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(size = 8.dp)
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(128.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 24.dp)
                ) {
                    when ("android") {
                        "ios" -> {
                            Icon(
                                painter = painterResource(Res.drawable.face_id),
                                contentDescription = null,
                                modifier = Modifier.size(iconSize)
                            )
                        }

                        else -> {
                            Icon(
                                painter = painterResource(Res.drawable.biometric),
                                contentDescription = null,
                                modifier = Modifier.size(iconSize)
                            )
                        }
                    }

                    Text(
                        text = "Create an account? ",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                        ),
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable { onGetStartedClick() },
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun RainbowText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.headlineSmall
) {
    val rainbowColors = listOf(
        NavyBlue500,
        Orange500,
        BurntOrange500,
        MaterialTheme.colorScheme.onBackground,
    )

    Text(
        text = text,
        style = style.copy(
            brush = Brush.linearGradient(
                colors = rainbowColors
            ),
        ),
        modifier = modifier
    )
}

@Preview()
@Composable
fun LoginScreenPreview() {
    FinanceLabsTheme {
        LoginScreen()
    }
}