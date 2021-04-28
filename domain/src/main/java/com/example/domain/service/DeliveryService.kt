package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.CarrierData
import com.example.domain.entity.TrackData
import io.reactivex.Single

interface DeliveryService {

    fun getCarrier(): Single<Result<List<CarrierData>>>

    fun getTrackData(): Single<Result<List<TrackData>>>

    fun singleDelete(carrierData: TrackData) : Single<Result<Unit>>

    fun allDelete(carrierData: Unit) : Single<Result<Unit>>
}