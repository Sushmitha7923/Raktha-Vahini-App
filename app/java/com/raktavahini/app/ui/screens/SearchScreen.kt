package com.raktavahini.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raktavahini.app.viewmodel.DonorViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: DonorViewModel
) {

    var bloodGroup by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Search Donor",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = bloodGroup,
            onValueChange = { bloodGroup = it },
            label = { Text("Enter Blood Group (A+, B+, O-)") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            // fetch data from Firebase
            viewModel.fetchDonors(bloodGroup)

            // navigate to list screen WITH parameter
            navController.navigate("list/$bloodGroup")

        }) {
            Text("Search Donors")
        }
    }
}