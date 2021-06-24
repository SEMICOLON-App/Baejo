package com.example.data.remote.entity

import com.example.domain.entity.DeliveryInformationData
import com.google.gson.annotations.SerializedName

data class DeliveryProgressDetailData(

    @SerializedName("time")
    val time : String,

    @SerializedName("status")
    val status : DeliveryProgressStatusData,

    @SerializedName("location")
    val location : DeliveryProgressLocationName
)

fun DeliveryProgressDetailData.toEntity() =
     DeliveryInformationData(
        time = time,
        location = location.locationName,
        detailState = status.status
    )


