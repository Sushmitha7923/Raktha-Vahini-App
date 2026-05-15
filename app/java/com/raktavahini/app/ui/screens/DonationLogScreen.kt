package com.raktavahini.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raktavahini.app.viewmodel.DonorViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DonationLogScreen(viewModel: DonorViewModel) {

    val donations = viewModel.donationList.value

    LaunchedEffect(Unit) {
        viewModel.fetchDonations()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "🩸 Donation History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "Total Donations: ${donations.size}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(donations) { donation ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("👤 ${donation.donorName}", style = MaterialTheme.typography.titleMedium)
                        Text("🩸 ${donation.bloodGroup}")

                        val date = SimpleDateFormat("dd MMM yyyy")
                            .format(Date(donation.date))

                        Text("📅 $date")
                        Text("🏥 ${donation.hospital}")
                    }
                }
            }
        }
    }
}