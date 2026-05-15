package com.raktavahini.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.raktavahini.app.R

@Composable
fun HomeScreen() {

    Box(modifier = Modifier.fillMaxSize()) {

        // 🖼️ BACKGROUND IMAGE
        Image(
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 🌫️ DARK OVERLAY (optional for readability)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        )

        // 🎯 FOREGROUND CONTENT
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            // 🖼️ FOREGROUND IMAGE (LOGO)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(120.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Rakta Vahini",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Donate Blood • Save Lives ❤️",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text("Get Started")
            }
        }
    }
}