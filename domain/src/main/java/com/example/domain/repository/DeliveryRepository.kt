package com.example.domain.repository

import com.example.domain.entity.CarrierData
import com.example.domain.entity.TrackData
import io.reactivex.Completable
import io.reactivex.Single

interface DeliveryRepository {

    fun getCarrier(): Single<List<CarrierData>>

    fun getTrackData(): Single<List<TrackData>>

    fun singleDelete(carrierData: CarrierData) : Completable

    fun allDelete(carrierData: CarrierData) : Completable
}