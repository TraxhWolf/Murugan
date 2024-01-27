package com.example.murugan.data

sealed class UIEvent{
    data class NewUsernameChanged(var newUsername: String) : UIEvent()
    data class NewPasswordChanged(var newPassword: String) : UIEvent()
    object RegisterButtonClicked: UIEvent()
}
