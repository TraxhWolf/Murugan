package com.example.murugan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.murugan.R
import com.example.murugan.navigation.MuruganNavigation
import com.example.murugan.navigation.Screen
import com.example.murugan.navigation.SystemBackButtonHandler
import com.example.murugan.ui.components.AppButtons
import com.example.murugan.ui.ui.theme.MuruganTheme

@Composable
fun GetMuruganScreen(
    modifier: Modifier = Modifier,
) {
    Box{
        Image(painter = painterResource(
            id = R.drawable.murugan),
            contentDescription = stringResource(R.string.frost_murugan_desc),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFEEEDED))
                    .padding(
                        bottom = 30.dp,
                        top = 30.dp
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.you_got_frost_muruganed_prompt),
                    fontSize = 20.sp,
                    color = Color.Black,
                )
                Text(
                    text = stringResource(R.string.logout_prompt),
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = modifier.height(30.dp))
                AppButtons(
                    buttonText = stringResource(id = R.string.logout_button),
                    onClick = { MuruganNavigation.navigateTo(Screen.HomeScreen) },
                    isEnabled = true
                )
            }
        }
    }

    SystemBackButtonHandler {
        MuruganNavigation.navigateTo(Screen.LoginScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun GetMuruganScreenPreview() {
    MuruganTheme {
        GetMuruganScreen()
    }
}