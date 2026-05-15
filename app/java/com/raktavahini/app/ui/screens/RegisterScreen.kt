package com.raktavahini.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raktavahini.app.model.Donor
import com.raktavahini.app.viewmodel.DonorViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: DonorViewModel
) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var bloodGroup by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Register Donor", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = bloodGroup,
            onValueChange = { bloodGroup = it },
            label = { Text("Blood Group") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val donor = Donor(
                name = name,
                phone = phone,
                bloodGroup = bloodGroup,
                location = location,
                lastDonationDate = System.currentTimeMillis(),
                available = true
            )

            viewModel.registerDonor(donor)

            navController.navigate("search")

        }) {
            Text("Register")
        }
    }
}