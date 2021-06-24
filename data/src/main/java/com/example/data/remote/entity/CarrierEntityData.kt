package com.example.data.remote.entity

import com.example.domain.entity.CarrierData
import com.google.gson.annotations.SerializedName

data class CarrierEntityData(

    @SerializedName("id")
    val courierServiceId: String,

    @SerializedName("name")
    val courierServiceName: String
)

fun CarrierEntityData.toEntity() =
    CarrierData(
        courierServiceId = courierServiceId,
        courierServiceName = courierServiceName
    )

fun CarrierData.toDataEntity() =
    CarrierEntityData(
        courierServiceId = courierServiceId,
        courierServiceName = courierServiceName
    )

