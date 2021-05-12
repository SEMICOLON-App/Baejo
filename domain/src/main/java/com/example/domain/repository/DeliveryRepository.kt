package com.example.domain.repository

import com.example.domain.entity.CarrierData
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.StorageData
import com.example.domain.entity.TrackData
import io.reactivex.Completable
import io.reactivex.Single

interface DeliveryRepository {

    fun getCarrier(): Single<List<CarrierData>>

    fun getTrackData(deliveryBasicInformationData: DeliveryBasicInformationData): Single<List<TrackData>>

    fun storageData(): Single<List<StorageData>>

    fun singleDelete(carrierData: TrackData) : Completable

    fun allDelete() : Completable
}