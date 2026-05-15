package com.raktavahini.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.content.Intent
import android.net.Uri
import com.raktavahini.app.viewmodel.DonorViewModel
import com.raktavahini.app.utils.isEligible

@Composable
fun DonorListScreen(
    blood: String,
    viewModel: DonorViewModel
) {

    val donors = viewModel.donorList.value
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Donors for $blood",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(donors) { donor ->

                if (isEligible(donor.lastDonationDate)) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(modifier = Modifier.padding(10.dp)) {

                            Text("Name: ${donor.name}")
                            Text("Blood Group: ${donor.bloodGroup}")
                            Text("Location: ${donor.location}")

                            Text(
                                text = if (isEligible(donor.lastDonationDate))
                                    "Eligible ✅"
                                else
                                    "Not Eligible ❌"
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(onClick = {

                                val intent = Intent(Intent.ACTION_DIAL)
                                intent.data = Uri.parse("tel:${donor.phone}")
                                context.startActivity(intent)

                            }) {
                                Text("Call Donor")
                            }
                        }
                    }
                }
            }
        }
    }
}