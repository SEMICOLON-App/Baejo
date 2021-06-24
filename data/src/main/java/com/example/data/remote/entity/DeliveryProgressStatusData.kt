package com.example.data.remote.entity

import com.google.gson.annotations.SerializedName

data class DeliveryProgressStatusData(

    @SerializedName("text")
    val status: String
)
