package com.example.data.remote.entity

import androidx.room.PrimaryKey
import com.example.data.local.SearchHistoryDatabase
import com.example.data.local.entity.SearchHistoryEntity
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.DeliveryProgress
import com.example.domain.entity.SearchHistoryData
import com.google.gson.annotations.SerializedName

data class DeliveryProgressData(

    @SerializedName("from")
    val from : DeliveryProgressFromData,

    @SerializedName("to")
    val to : DeliveryProgressToData,

    @SerializedName("state")
    val status : DeliveryProgressStatusData,

    @SerializedName("progress")
    val progress : List<DeliveryProgressDetailData>,

    @SerializedName("carrierData")
    val carrier : CarrierEntityData,

    @PrimaryKey
    val waybillNumber: String,

    val courierServiceName: String,

    val date : String
)

fun DeliveryProgressData.toEntity() =
    DeliveryProgress(
        courierServiceName= courierServiceName,
        waybillNumber = waybillNumber,
        receive = to.toName,
        dispatch = from.fromName,
        deliveryState = status.status,
        deliveryInformation = progress.map { it.toEntity() }
    )

