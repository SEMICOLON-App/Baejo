package com.example.data.remote.entity

import com.example.domain.entity.DeliveryBasicInformationData

data class DeliveryInformationEntityData(
    val courierServiceId: String,

    val waybillNumber: String
)

fun DeliveryBasicInformationData.toEntity() =
    DeliveryInformationEntityData(
        courierServiceId= courierServiceId,
        waybillNumber = waybillNumber
    )
