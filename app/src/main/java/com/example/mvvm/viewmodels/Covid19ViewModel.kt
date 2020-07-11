package com.example.mvvm.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.DataList
import com.example.mvvm.utils.RetroFitApiFunction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class Covid19ViewModel : ViewModel {
    var date = ""
    var dailyconfirmed = ""
    var dailydeceased = ""
    var dailyrecovered = ""
    var totalconfirmed = ""
    var totaldeceased = ""
    var totalrecovered = ""

    constructor() : super()

    constructor(covid: DataList) : super() {
        this.date = covid.date.toString();
        this.dailyconfirmed = covid.dailyconfirmed.toString();
        this.dailydeceased = covid.dailydeceased.toString();
        this.dailyrecovered = covid.dailyrecovered.toString();
        this.totalconfirmed = covid.totalconfirmed.toString();
        this.totaldeceased = covid.totaldeceased.toString();
        this.totalrecovered = covid.totalrecovered.toString();
    }

    var arrayListMutableLiveData = MutableLiveData<ArrayList<Covid19ViewModel>>()
    var arraylist = ArrayList<Covid19ViewModel>()

    fun getCovidDataForIndia(): MutableLiveData<ArrayList<Covid19ViewModel>> {
        print("Task 1")
        GlobalScope.launch(Dispatchers.IO){
            println("Task 2")
            val response = RetroFitApiFunction.api().getIndiaCovid19Data()
            println("Task 3")
            if (response.isSuccessful) {
                println("Task 4")
                for (i in response.body()?.DataList!!) {
                    var covidModel: Covid19ViewModel = Covid19ViewModel(i)
                    arraylist.add(covidModel)
                }
                println("Task 5:" + arraylist)
                arrayListMutableLiveData.postValue(arraylist)
            } else {
                print("Error : something")
            }
        }
        print("Task 6")
        return arrayListMutableLiveData
    }
}