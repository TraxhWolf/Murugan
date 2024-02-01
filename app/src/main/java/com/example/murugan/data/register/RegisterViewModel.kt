package com.example.murugan.data.register
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.murugan.data.Validator
import com.example.murugan.navigation.MuruganNavigation
import com.example.murugan.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel: ViewModel() {

    var registerScreenUIState = mutableStateOf(RegisterScreenUIState())
    var validationsPassed = mutableStateOf(false)
    var registerProgress = mutableStateOf(false)

    fun onEvent(event: RegisterUIEvent) {
        validateData()
        when(event) {
            is RegisterUIEvent.NewUsernameChanged -> {
                registerScreenUIState.value = registerScreenUIState.value.copy(
                    newUsername = event.newUsername
                )
            }
            is RegisterUIEvent.NewPasswordChanged -> {
                registerScreenUIState.value = registerScreenUIState.value.copy(
                    newPassword = event.newPassword
                )
            }
            is RegisterUIEvent.RegisterButtonClicked -> {
                register()
            }
        }
    }

    private fun register() {
        registerUser(
            userName = registerScreenUIState.value.newUsername,
            password = registerScreenUIState.value.newPassword
        )
    }

    private fun validateData() {
        val newUsername = Validator.validateUsername(
            username = registerScreenUIState.value.newUsername
        )
        val newPassword = Validator.validatePassword(
            password = registerScreenUIState.value.newPassword
        )
        registerScreenUIState.value = registerScreenUIState.value.copy(
            newUsernameError = newUsername.status,
            newPasswordError = newPassword.status
        )

        validationsPassed.value = newUsername.status && newPassword.status
    }

    private fun registerUser(
        userName: String,
        password: String
    ) {
        registerProgress.value = true
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(userName, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    MuruganNavigation.navigateTo(Screen.LoginScreen)
                }
            }
            .addOnFailureListener{}
    }
}