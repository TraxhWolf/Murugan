package com.example.murugan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.murugan.R
import com.example.murugan.navigation.MuruganNavigation
import com.example.murugan.navigation.Screen
import com.example.murugan.ui.components.AppButtons
import com.example.murugan.ui.ui.theme.MuruganTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
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
                .fillMaxHeight(.5f)
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
                text = stringResource(R.string.home),
                fontSize = 24.sp
            )
            Spacer(modifier = modifier.height(70.dp))
            AppButtons(
                buttonText = stringResource(id = R.string.register_button),
                onClick = { MuruganNavigation.navigateTo(Screen.RegisterScreen) },
                isEnabled = true
            )
            Spacer(modifier = modifier.height(50.dp))
            AppButtons(
                buttonText = stringResource(id = R.string.login_button),
                onClick = { MuruganNavigation.navigateTo(Screen.LoginScreen) },
                isEnabled = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MuruganTheme {
        HomeScreen()
    }
}