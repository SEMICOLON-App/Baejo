package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.CarrierData
import com.example.domain.entity.TrackData
import com.example.domain.repository.DeliveryRepository
import com.example.domain.toResult
import com.example.domain.toSingleResult
import io.reactivex.Single

class DeliveryServiceImpl(
    private val repository: DeliveryRepository
):DeliveryService
    {
        override fun getCarrier(): Single<Result<List<CarrierData>>> =
            repository.getCarrier().toResult()

        override fun getTrackData(): Single<Result<List<TrackData>>> =
            repository.getTrackData().toResult()

        override fun singleDelete(carrierData: TrackData): Single<Result<Unit>> =
            repository.singleDelete(carrierData).toSingleResult()


        override fun allDelete(carrierData: Unit): Single<Result<Unit>> =
            repository.allDelete(carrierData).toSingleResult()

    }