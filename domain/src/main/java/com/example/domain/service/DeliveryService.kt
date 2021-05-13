package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.*
import io.reactivex.Single

interface DeliveryService {

    fun getCarrier(): Single<Result<List<CarrierData>>>

    fun getDeliveryProgress(deliveryBasicInformationData: DeliveryBasicInformationData): Single<Result<List<TrackData>>>

    fun shortage(): Single<Result<List<StorageData>>>

    fun deleteSearchHistory(data: TrackData): Single<Result<Unit>>

    fun deleteAllSearchHistory(): Single<Result<Unit>>

    fun inquiryResult(deliveryBasicInformationData: DeliveryBasicInformationData): Single<Result<InquiryResultData>>
}