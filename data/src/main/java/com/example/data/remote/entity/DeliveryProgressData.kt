package com.example.data.remote.entity

data class DeliveryProgressData(
    val from : DeliveryProgressFromData,

    val to : DeliveryProgressToData,

    val state : List<DeliveryProgressDetailData>
)
