package com.example.data.remote.entity

data class DeliveryProgressDetailData(
    val time : String,

    val location : DeliveryProgressLocationName,

    val status : DeliveryProgressStatusData,

    val description : String
)
