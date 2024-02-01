package com.example.murugan.data.register

sealed class RegisterUIEvent{
    data class NewUsernameChanged(val newUsername: String) : RegisterUIEvent()
    data class NewPasswordChanged(val newPassword: String) : RegisterUIEvent()
    object RegisterButtonClicked: RegisterUIEvent()
}
