package com.toyelabs.financelabs.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.toyelabs.financelabs.theme.Transparent
import financelabs.composeapp.generated.resources.Res
import financelabs.composeapp.generated.resources.baseline_account_balance_24
import financelabs.composeapp.generated.resources.ic_stopwatch
import financelabs.composeapp.generated.resources.twotone_aod_24
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun OnboardingScreen(
    onConfirmClick: () -> Unit = { }
) {
    val topUpOptions = listOf("1 Week", "1 month", "2 months")

    var phoneNumber by remember { mutableStateOf("") }
    var selectedTopUp by remember { mutableStateOf(topUpOptions[0]) }
    var scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(scrollState),
        )  {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Welcome",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.offset(y = 6.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Automate. Orchestrate. Elevate",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { input ->
                    phoneNumber = input.filter { it.isDigit() }.take(11)
                },
                label = { Text("BVN") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = RoundedCornerShape(size = 12.dp),
            )

            Spacer(modifier = Modifier.height(3.h))

            Text(
                text = "Top-up Schedule",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            TopUpScheduleChipSelector(topUpOptions, selectedTopUp) { selectedTopUp = it }

            Spacer(modifier = Modifier.height(3.h))

            Text(
                text = "Account Linking",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            AccountLinkingCard(Res.drawable.twotone_aod_24, "Add bank account")

            Spacer(modifier = Modifier.height(12.dp))

            AccountLinkingCard(Res.drawable.ic_stopwatch, "Add Meter Number")

            Spacer(modifier = Modifier.height(12.dp))

            AccountLinkingCard(Res.drawable.twotone_aod_24, "Add more phone numbers")

            Spacer(modifier = Modifier.height(3.h))

            Button(
                onClick = onConfirmClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 8.dp)
            ) {
                Text("Confirm")
            }
        }
    }
}

@Composable
private fun AccountLinkingCard(
    drawableResource: DrawableResource,
    text: String
) {
    ElevatedCard(
        modifier = Modifier
            .height(10.h)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                shape = RoundedCornerShape(size = 12.dp)
            ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.9f),
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.width(5.w))

            Icon(
                painter = painterResource(drawableResource),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun TopUpScheduleChipSelector(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        options.forEach {
            option ->
            FilterChip(
                selected = selectedOption == option,
                onClick = { onOptionSelected(option) },
                label = { Text(
                    text = option,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                ) },
                modifier = Modifier
                    .width(30.w)
                    .height(6.h)
                    .padding(4.dp),
                colors = SelectableChipColors(
                    containerColor = Transparent,
                    labelColor = MaterialTheme.colorScheme.secondary,
                    leadingIconColor = Transparent,
                    trailingIconColor = Transparent,
                    disabledContainerColor = Transparent,
                    disabledLabelColor = Transparent,
                    disabledLeadingIconColor = Transparent,
                    disabledTrailingIconColor = Transparent,
                    selectedContainerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f),
                    disabledSelectedContainerColor = Transparent,
                    selectedLabelColor = MaterialTheme.colorScheme.primary,
                    selectedLeadingIconColor = MaterialTheme.colorScheme.primary,
                    selectedTrailingIconColor = MaterialTheme.colorScheme.primary
                ),
            )
        }
    }
}
