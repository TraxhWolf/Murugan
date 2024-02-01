package com.example.murugan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.murugan.R
import com.example.murugan.data.register.RegisterUIEvent
import com.example.murugan.data.register.RegisterViewModel
import com.example.murugan.navigation.MuruganNavigation
import com.example.murugan.navigation.Screen
import com.example.murugan.navigation.SystemBackButtonHandler
import com.example.murugan.ui.components.AppButtons
import com.example.murugan.ui.components.InputFields
import com.example.murugan.ui.components.PasswordInputField
import com.example.murugan.ui.ui.theme.MuruganTheme

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    registerViewModel: RegisterViewModel = viewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.6f)
                    .padding(10.dp)
                    .background(
                        color = Color.Transparent
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black
                    )
            ) {
                Text(
                    text = stringResource(R.string.register),
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(modifier = modifier.height(60.dp))
                InputFields(
                    label = stringResource(R.string.new_username),
                    onValueChange = {
                        registerViewModel.onEvent(
                            RegisterUIEvent.NewUsernameChanged(
                                it
                            )
                        )
                    },
                    error = registerViewModel.registerScreenUIState.value.newUsernameError
                )
                Spacer(modifier = modifier.height(50.dp))
                PasswordInputField(
                    label = stringResource(id = R.string.new_password),
                    onValueChange = {
                        registerViewModel.onEvent(
                            RegisterUIEvent.NewPasswordChanged(
                                it
                            )
                        )
                    },
                    error = registerViewModel.registerScreenUIState.value.newPasswordError
                )
                Spacer(modifier = modifier.height(50.dp))
                AppButtons(
                    buttonText = stringResource(id = R.string.register_button),
                    onClick = { registerViewModel.onEvent(RegisterUIEvent.RegisterButtonClicked) },
                    isEnabled = registerViewModel.validationsPassed.value
                )
            }
        }
        if(registerViewModel.registerProgress.value) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .alpha(.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    color = Color.Black
                )
            }
        }
    }

    SystemBackButtonHandler {
        MuruganNavigation.navigateTo(Screen.HomeScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    MuruganTheme {
        RegisterScreen()
    }
}