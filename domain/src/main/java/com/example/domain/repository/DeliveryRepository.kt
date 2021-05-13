package com.example.domain.repository

import com.example.domain.entity.*
import io.reactivex.Completable
import io.reactivex.Single

interface DeliveryRepository {

    fun getCarrier(): Single<List<CarrierData>>

    fun getDeliveryProgress(deliveryBasicInformationData: DeliveryBasicInformationData): Single<List<TrackData>>

    fun storageData(): Single<List<StorageData>>

    fun deleteSearchHistory(carrierData: TrackData) : Completable

    fun deleteAllSearchHistory() : Completable

    fun inquiryResult(deliveryBasicInformationData: DeliveryBasicInformationData) : Single<InquiryResultData>
}