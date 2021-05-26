package com.example.domain.entity

data class DeliveryProgress(

    val courierServiceName: String,

    val waybillNumber: String,

    val receive : String,

    val dispatch : String,

    val deliveryState: String,

    val deliveryInformation: List<DeliveryInformationData>
)