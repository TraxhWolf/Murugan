package com.example.murugan.data
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var userName by mutableStateOf("")
    var password by mutableStateOf("")

    fun userNameChanged(value: String) {
        userName = value
    }
    fun passwordChanged(value: String) {
        password = value
    }
}