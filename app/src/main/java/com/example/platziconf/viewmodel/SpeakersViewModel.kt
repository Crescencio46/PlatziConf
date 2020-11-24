package com.example.platziconf.viewmodel

import android.telecom.Conference
import androidx.lifecycle.MutableLiveData
import com.example.platziconf.model.Speaker
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakersViewModel {
    val firestoreService = FirestoreService()
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase(){
        firestoreService.getSpeakers(object: Callback<List<Speaker>>{
            onS
        })
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}