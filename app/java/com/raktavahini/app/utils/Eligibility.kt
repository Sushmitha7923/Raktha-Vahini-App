package com.raktavahini.app.utils

fun isEligible(lastDonationDate: Long): Boolean {
    val now = System.currentTimeMillis()
    val ninetyDays = 90L * 24 * 60 * 60 * 1000
    return (now - lastDonationDate) >= ninetyDays
}

fun nextEligibleDate(lastDonationDate: Long): String {
    val next = lastDonationDate + (90L * 24 * 60 * 60 * 1000)
    return java.text.SimpleDateFormat("dd MMM yyyy")
        .format(java.util.Date(next))
}