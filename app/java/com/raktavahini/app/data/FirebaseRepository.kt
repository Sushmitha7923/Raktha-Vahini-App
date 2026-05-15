package com.raktavahini.app.data

import com.google.firebase.firestore.FirebaseFirestore
import com.raktavahini.app.model.Donor
import com.raktavahini.app.model.Donation

class FirebaseRepository {

    private val db = FirebaseFirestore.getInstance()

    fun addDonor(donor: Donor) {
        db.collection("donors").add(donor)
    }

    fun getDonors(bloodGroup: String, onResult: (List<Donor>) -> Unit) {
        db.collection("donors")
            .whereEqualTo("bloodGroup", bloodGroup)
            .get()
            .addOnSuccessListener {
                onResult(it.documents.mapNotNull { d ->
                    d.toObject(Donor::class.java)
                })
            }
    }

    fun getDonations(onResult: (List<Donation>) -> Unit) {
        db.collection("donations")
            .get()
            .addOnSuccessListener {
                onResult(it.documents.mapNotNull { d ->
                    d.toObject(Donation::class.java)
                })
            }
    }
}