package com.example.mvvm.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.covid19india.org/"

object RetroFitApiFunction {
    fun api(): ApiCallFunctions {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCallFunctions::class.java)!!
    }
}
