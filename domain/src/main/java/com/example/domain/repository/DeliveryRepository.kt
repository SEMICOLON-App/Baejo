package com.example.domain.repository

import com.example.domain.entity.*
import io.reactivex.Completable
import io.reactivex.Single

interface DeliveryRepository {

    fun getCarrier(): Single<List<CarrierData>>

    fun getDeliveryProgress(deliveryBasicInformationData: DeliveryBasicInformationData): Single<List<DeliveryProgress>>

    fun searchHistoryData(): Single<List<SearchHistoryData>>

    fun deleteSearchHistory(carrierData: DeliveryProgress): Completable

    fun deleteAllSearchHistory(): Completable
}