package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchHistoryEntity (

    @PrimaryKey
    val waybillNumber: String,

    val courierServiceName: String,

    val date : String
)