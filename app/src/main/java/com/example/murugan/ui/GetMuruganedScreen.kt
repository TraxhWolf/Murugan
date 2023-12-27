package com.example.murugan.ui

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.murugan.ui.ui.theme.MuruganTheme

@Composable
fun GetMuruganScreen(
    onLogoutButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
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
                Button(
                    onClick = onLogoutButtonClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    modifier = Modifier
                        .height(40.dp)
                        .width(270.dp)
                        .background(color = Color.Black)
                ) {
                    Text(
                        text = stringResource(R.string.logout_button),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetMuruganScreenPreview() {
    MuruganTheme {
        GetMuruganScreen(
            onLogoutButtonClicked = {}
        )
    }
}