package com.example.domain.entity

data class InquiryResultData(
    val deliveryBasicInformationData: DeliveryBasicInformationData,
    val receive : String,
    val dispatch : String,
    val state : String
)