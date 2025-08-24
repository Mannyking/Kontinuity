package com.toyelabs.financelabs.ui.onboarding

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.toyelabs.financelabs.ui.h

@Composable
fun PreOnboardingScreen(
    viewModel: PreOnboardingViewModel = remember { PreOnboardingViewModel() },
    onConfirmClick: () -> Unit = { }
) {
    var phoneNumber by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }

    val isEmailSent by viewModel.isEmailSent
    val isEmailVerified by viewModel.isEmailVerified

    val isPhoneNumberVerified by viewModel.isPhoneNumberVerified

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
                text = viewModel.dummyText.value,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.Companion.height(1.h))

            OutlinedTextField(
                value = emailAddress,
                onValueChange = {
                    emailAddress = it
                    viewModel.validateEmailAddress(emailAddress)
                },
                label = { Text("Email Address") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                shape = RoundedCornerShape(size = 12.dp)
            )

            Spacer(modifier = Modifier.height(1.h))

            if (isEmailSent) Text(
                text = "Heads up! We've dropped something in your email's inbox",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                modifier = Modifier.padding(start = 4.dp),
            )

            Spacer(modifier = Modifier.height(1.h))

            if (isEmailVerified) OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = RoundedCornerShape(size = 12.dp)
            )

            if (isEmailSent) Spacer(modifier = Modifier.height(4.h))

            if (!isEmailVerified) Button(
                onClick = { viewModel.sendEmail() },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Text("Verify")
            }

            if (isEmailVerified) Button(
                onClick = { viewModel.validatePhoneNumber(phoneNumber) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Text("Request OTP")
            }

            if (isPhoneNumberVerified) {
                Toast.makeText(LocalContext.current, "Personal Info recorded", Toast.LENGTH_SHORT).show()
                onConfirmClick()
            }
        }
    }
}
