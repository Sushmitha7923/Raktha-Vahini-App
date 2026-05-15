package com.raktavahini.app.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raktavahini.app.data.FirebaseRepository
import com.raktavahini.app.model.Donor
import com.raktavahini.app.model.Donation

class DonorViewModel : ViewModel() {

    private val repository = FirebaseRepository()

    // 🩸 Donor list
    var donorList = mutableStateOf(listOf<Donor>())

    // 📋 Donation list (THIS FIXES YOUR ERROR)
    var donationList = mutableStateOf(listOf<Donation>())

    // 🩸 Register donor
    fun registerDonor(donor: Donor) {
        repository.addDonor(donor)
    }

    // 🔍 Fetch donors
    fun fetchDonors(bloodGroup: String) {
        repository.getDonors(bloodGroup) { list ->
            donorList.value = list
        }
    }

    // 📋 Fetch donation log
    fun fetchDonations() {
        repository.getDonations { list ->
            donationList.value = list
        }
    }
}