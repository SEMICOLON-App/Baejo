package com.example.data.remote.entity

import com.google.gson.annotations.SerializedName

data class CarrierData(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String
)
