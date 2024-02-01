package com.example.murugan.data.register

data class RegisterScreenUIState (
    var newUsername: String = "",
    var newPassword: String = "",

    var newUsernameError: Boolean = false,
    var newPasswordError: Boolean = false
)