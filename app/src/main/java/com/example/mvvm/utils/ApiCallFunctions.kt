package com.example.mvvm.utils
import com.example.mvvm.models.Covid19DataClass
import retrofit2.Response
import retrofit2.http.GET

interface ApiCallFunctions{
    @GET("data.json")
    suspend fun getIndiaCovid19Data(): Response<Covid19DataClass>
}