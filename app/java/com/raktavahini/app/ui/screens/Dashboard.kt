package com.raktavahini.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raktavahini.app.viewmodel.DonorViewModel

@Composable
fun Dashboard(viewModel: DonorViewModel) {

    val donors = viewModel.donorList.value
    val donations = viewModel.donationList.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📊 Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(modifier = Modifier.padding(16.dp)) {

                Text("👥 Total Donors: ${donors.size}")
                Text("🩸 Total Donations: ${donations.size}")
            }
        }
    }
}