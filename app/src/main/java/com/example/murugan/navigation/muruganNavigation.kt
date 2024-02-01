package com.example.murugan.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object HomeScreen: Screen()
    object RegisterScreen: Screen()
    object LoginScreen: Screen()
    object GetMuruganedScreen: Screen()
}

object MuruganNavigation {
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)
    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}
