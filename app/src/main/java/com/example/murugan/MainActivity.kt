package com.example.murugan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.murugan.navigation.MuruganNavigation
import com.example.murugan.navigation.Screen
import com.example.murugan.ui.screens.GetMuruganScreen
import com.example.murugan.ui.screens.HomeScreen
import com.example.murugan.ui.screens.LoginScreen
import com.example.murugan.ui.screens.RegisterScreen
import com.example.murugan.ui.theme.MuruganTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuruganTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

/*
enum class AppScreens{
    Home,
    Register,
    Login,
    GetMuruganed
}
 */


@Composable
fun App() {

/*
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.Home.name
    ) {
        composable(route = AppScreens.Home.name) {
            HomeScreen(
                onRegisterButtonClicked = { navController.navigate(AppScreens.Register.name) },
                onLoginButtonClicked = { navController.navigate(AppScreens.Login.name) }
            )
        }
        composable(route = AppScreens.Register.name) {
            RegisterScreen(
                onRegisterScreenButtonClicked = { navController.navigate(AppScreens.Login.name) }
            )
        }
        composable(route = AppScreens.Login.name) {
            LoginScreen(
                onLoginScreenButtonClicked = { navController.navigate(AppScreens.GetMuruganed.name) }
            )
        }
        composable(route = AppScreens.GetMuruganed.name) {
            GetMuruganScreen(
                onLogoutButtonClicked = {
                    navController.popBackStack(
                        route = AppScreens.Home.name,
                        inclusive = false
                    )
                }
            )
        }
    }
*/

    Crossfade(targetState = MuruganNavigation.currentScreen, label = "") { currentState ->
        when(currentState.value){
            is Screen.HomeScreen -> {
                HomeScreen()
            }
            is Screen.RegisterScreen -> {
                RegisterScreen()
            }
            is Screen.LoginScreen -> {
                LoginScreen()
            }
            is Screen.GetMuruganedScreen -> {
                GetMuruganScreen()
            }
        }
    }
}