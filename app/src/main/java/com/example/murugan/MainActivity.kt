package com.example.murugan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.murugan.ui.GetMuruganScreen
import com.example.murugan.ui.HomeScreen
import com.example.murugan.ui.LoginScreen
import com.example.murugan.ui.RegisterScreen
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

enum class AppScreens{
    Home,
    Register,
    Login,
    GetMuruganed
}

@Composable
fun App() {
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
                onLogoutButtonClicked = { navController.popBackStack(
                    route = AppScreens.Home.name,
                    inclusive = false
                ) }
            )
        }
    }
}
