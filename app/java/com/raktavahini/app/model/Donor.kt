package com.raktavahini.app.model

data class Donor(
    val name: String = "",
    val phone: String = "",
    val bloodGroup: String = "",
    val location: String = "",
    val lastDonationDate: Long = 0L,
    val available: Boolean = true
)