package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.CarrierData
import com.example.domain.entity.TrackData
import com.example.domain.repository.DeliveryRepository
import com.example.domain.toResult
import io.reactivex.Single

class DeliveryServiceImpl(
    val repository: DeliveryRepository
):DeliveryService
    {
        override fun getCarrier(): Single<Result<List<CarrierData>>> =
            repository.getCarrier().toResult()

        override fun getTrackData(): Single<Result<List<TrackData>>> {
            TODO("Not yet implemented")
        }

        override fun singleDelete(carrierData: TrackData): Single<Result<Unit>> {
            TODO("Not yet implemented")
        }

        override fun allDelete(carrierData: Unit): Single<Result<Unit>> {
            TODO("Not yet implemented")
        }

    }