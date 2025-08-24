package com.toyelabs.financelabs.ui.onboarding

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PreOnboardingViewModel : ViewModel() {
    companion object {
        private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    }

    private val _isEmailAddressValid = mutableStateOf(false)
    val isEmailAddressValid: State<Boolean> get() = _isEmailAddressValid

    private val _isEmailSent = mutableStateOf(false)
    val isEmailSent: State<Boolean> get() = _isEmailSent

    private val _isEmailVerified = mutableStateOf(false)
    val isEmailVerified: State<Boolean> get() = _isEmailVerified

    private val _isPhoneNumberValid = mutableStateOf(false)
    val isPhoneNumberValid: State<Boolean> get() = _isPhoneNumberValid

    private val _isPhoneNumberVerified = mutableStateOf(false)
    val isPhoneNumberVerified: State<Boolean> get() = _isPhoneNumberVerified

    private val _dummyText = mutableStateOf("Let's get you set up")
    val dummyText: State<String> get() = _dummyText

    fun validateEmailAddress(emailAddress: String) {
        _isEmailAddressValid.value = EMAIL_REGEX.matches(emailAddress)
    }

    fun sendEmail() {
        viewModelScope.launch {
            if (!_isEmailAddressValid.value) return@launch

            delay(4000)
            _isEmailSent.value = true

            delay(3000)
            _isEmailVerified.value = true
        }
    }

    fun validatePhoneNumber(phoneNumber: String) {
        viewModelScope.launch {
            _isPhoneNumberValid.value = phoneNumber.startsWith("0")

            delay(3000)
            _isPhoneNumberVerified.value = true
        }
    }
}
