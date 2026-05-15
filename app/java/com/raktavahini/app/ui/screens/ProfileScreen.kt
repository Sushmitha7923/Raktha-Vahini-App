package com.raktavahini.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raktavahini.app.model.Donor

@Composable
fun ProfileScreen(donor: Donor) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "👤 Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier.padding(16.dp)) {

                Text("Name: ${donor.name}")
                Text("Phone: ${donor.phone}")
                Text("Blood Group: ${donor.bloodGroup}")
                Text("Location: ${donor.location}")

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = if (donor.available)
                        "Available to Donate ✅"
                    else
                        "Not Available ❌"
                )
            }
        }
    }
}