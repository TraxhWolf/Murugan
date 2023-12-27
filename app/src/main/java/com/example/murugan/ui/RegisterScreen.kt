package com.example.murugan.ui

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.murugan.R
import com.example.murugan.ui.components.InputFields
import com.example.murugan.ui.ui.theme.MuruganTheme

@Composable
fun RegisterScreen(
    onRegisterScreenButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    var newUserName by rememberSaveable { mutableStateOf("") }
    var newPassword by rememberSaveable { mutableStateOf("") }

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
        ){
            Text(
                text = stringResource(R.string.register),
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = modifier.height(60.dp))
            InputFields(
                label = stringResource(R.string.new_username),
                value = newUserName,
                onValueChange = { newUserName = it }
            )
            Spacer(modifier = modifier.height(50.dp))
            InputFields(
                label = stringResource(R.string.new_password),
                value = newPassword,
                onValueChange = { newPassword = it}
            )
            Spacer(modifier = modifier.height(50.dp))
            Button(
                onClick = onRegisterScreenButtonClicked,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier
                    .height(40.dp)
                    .width(270.dp)
                    .background(color = Color.Black)
            ) {
                Text(
                    text = stringResource(R.string.register_button),
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    MuruganTheme {
        RegisterScreen(
            onRegisterScreenButtonClicked = {}
        )
    }
}