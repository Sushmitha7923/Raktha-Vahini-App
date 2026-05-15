package com.raktavahini.app.model

data class Donation(

    // 👤 Donor name
    val donorName: String = "",

    // 🩸 Blood group (A+, B-, etc.)
    val bloodGroup: String = "",

    // 📅 Donation date (store as timestamp)
    val date: Long = 0L,

    // 🏥 Hospital name
    val hospital: String = ""
)