package com.example.murugan.data
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {

    /*
    var newUsername by mutableStateOf("")
    var newPassword by mutableStateOf("")

    fun newUsernameChanged(value: String) {
        newUsername = value
    }
    fun newPasswordChanged(value: String) {
        newPassword = value
    }
    */

    private val TAG = RegisterViewModel::class.simpleName
    private var registerScreenUIState = mutableStateOf(RegisterScreenUIState())

    fun onEvent(event: UIEvent) {
        when(event) {
            is UIEvent.NewUsernameChanged -> {
                registerScreenUIState.value = registerScreenUIState.value.copy(
                    newUsername = event.newUsername
                )
                printState()
            }
            is UIEvent.NewPasswordChanged -> {
                registerScreenUIState.value = registerScreenUIState.value.copy(
                    newPassword = event.newPassword
                )
                printState()
            }
            is UIEvent.RegisterButtonClicked -> {
                register()
            }
        }
    }

    private fun register() {

    }

    private fun printState() {
        Log.d(TAG, "UserInputsFR")
        Log.d(TAG, registerScreenUIState.value.toString())
    }

    companion object {
        fun onEvent(registerButtonClicked: UIEvent.RegisterButtonClicked) {

        }
    }

}