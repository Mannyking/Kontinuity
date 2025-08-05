package com.toyelabs.financelabs.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.math.sin

@Composable
fun PreOnboardingScreen(
    onConfirmClick: () -> Unit = { }
) {
    var phoneNumber by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }
    var isPhoneNumberValid by remember { mutableStateOf("") }
    var isPhoneNumberVerified by remember { mutableStateOf(false) }
    var isEmailSent by remember { mutableStateOf(false) }
    var isEmailVerified by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Hello!",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.offset(y = 6.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Let's get you set up",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(1.h))

            OutlinedTextField(
                value = emailAddress,
                onValueChange = { emailAddress = it },
                label = { Text("Email Address") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                shape = RoundedCornerShape(size = 12.dp)
            )

            Spacer(modifier = Modifier.height(1.h))

            if (isEmailSent) Text(
                text = "Heads up! We've dropped something in your email inbox",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                modifier = Modifier.padding(start = 4.dp),
            )

            Spacer(modifier = Modifier.height(1.h))

            if (isEmailSent) OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = RoundedCornerShape(size = 12.dp)
            )

            if (isEmailSent) Spacer(modifier = Modifier.height(4.h))

            Button(
                onClick = onConfirmClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Text("Validate")
            }
        }
    }
}
