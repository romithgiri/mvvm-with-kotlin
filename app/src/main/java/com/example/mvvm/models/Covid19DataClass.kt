package com.example.mvvm.models

import com.google.gson.annotations.SerializedName

data class Covid19DataClass(
    @SerializedName("cases_time_series")
    var DataList: List<DataList2>? = null
)

data class DataList2(
    @SerializedName("dailyconfirmed")
    var dailyconfirmed: String? = null,
    @SerializedName("dailydeceased")
    var dailydeceased: String? = null,
    @SerializedName("dailyrecovered")
    var dailyrecovered: String? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("totalconfirmed")
    var totalconfirmed: String? = null,
    @SerializedName("totaldeceased")
    var totaldeceased: String? = null,
    @SerializedName("totalrecovered")
    var totalrecovered: String? = null
)