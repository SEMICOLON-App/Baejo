package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.*
import io.reactivex.Single

interface DeliveryService {

    fun getCarrier(): Single<Result<List<CarrierData>>>

    fun getDeliveryProgress(deliveryBasicInformationData: DeliveryBasicInformationData): Single<Result<DeliveryProgress>>

    fun searchHistory(): Single<Result<List<SearchHistoryData>>>

    fun deleteSearchHistory(data: SearchHistoryData): Single<Result<Unit>>

    fun deleteAllSearchHistory(): Single<Result<Unit>>
}