package com.example.platziconf.network

import com.example.platziconf.model.Conference
import com.example.platziconf.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init{
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>){
            firebaseFirestore.collection("speakers")
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<android.telecom.Conference>>){
        firebaseFirestore.collection("conferences")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}