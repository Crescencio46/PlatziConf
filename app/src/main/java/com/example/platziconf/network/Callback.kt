package com.example.platziconf.network

import com.example.platziconf.model.Conference
import java.lang.Exception

interface Callback<T> {
    fun onSuccess(result: MutableList<Conference>)

    fun onFailed(exception: Exception)
}