package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.SearchHistoryData

@Entity
data class SearchHistoryEntity(

    @PrimaryKey
    val waybillNumber: String,

    val courierServiceName: String,

    val date: String
)

fun SearchHistoryEntity.toEntity() =
    SearchHistoryData(
        waybillNumber = waybillNumber,
        courierServiceName = courierServiceName,
        date = date
    )

fun SearchHistoryData.toDataEntity() =
        SearchHistoryEntity(
            waybillNumber = waybillNumber,
            courierServiceName = courierServiceName,
            date = date
        )