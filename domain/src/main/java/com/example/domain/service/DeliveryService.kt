package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.CarrierData
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.StorageData
import com.example.domain.entity.TrackData
import io.reactivex.Single

interface DeliveryService {

    fun getCarrier(): Single<Result<List<CarrierData>>>

    fun getTrackData(deliveryBasicInformationData: DeliveryBasicInformationData): Single<Result<List<TrackData>>>

    fun shortage(): Single<Result<List<StorageData>>>

    fun singleDelete(data: TrackData): Single<Result<Unit>>

    fun allDelete() : Single<Result<Unit>>
}