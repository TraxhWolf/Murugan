package com.example.murugan.data.login

sealed class LoginUIEvent{

    data class UsernameChanged(val username: String): LoginUIEvent()
    data class PasswordChanged(val password: String): LoginUIEvent()
    object LoginButtonClicked: LoginUIEvent()

}
