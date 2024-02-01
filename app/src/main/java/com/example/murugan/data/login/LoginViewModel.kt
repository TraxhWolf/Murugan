package com.example.murugan.data.login
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.murugan.data.Validator
import com.example.murugan.navigation.MuruganNavigation
import com.example.murugan.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {

    var loginUIState = mutableStateOf(LoginUIState())
    var validationsPassed = mutableStateOf(false)
    var loginProgress = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {
        when(event){
            is LoginUIEvent.UsernameChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    username = event.username
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateLogin()
    }

    private fun validateLogin() {
        val enteredUsername = Validator.validateUsername(
            username = loginUIState.value.username
        )
        val enteredPassword = Validator.validatePassword(
            password = loginUIState.value.password
        )
        loginUIState.value = loginUIState.value.copy(
            usernameError = enteredUsername.status,
            passwordError = enteredPassword.status
        )
        validationsPassed.value = enteredUsername.status && enteredPassword.status
    }

    private fun login() {

        val username = loginUIState.value.username
        val password = loginUIState.value.password
        loginProgress.value = true

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(username, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    MuruganNavigation.navigateTo(Screen.GetMuruganedScreen)
                }
            }
            .addOnFailureListener{}

    }
}