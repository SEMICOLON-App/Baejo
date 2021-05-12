package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.CarrierData
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.StorageData
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

        override fun getTrackData(
            deliveryBasicInformationData: DeliveryBasicInformationData
        ): Single<Result<List<TrackData>>> =
            repository.getTrackData(deliveryBasicInformationData).toResult()

        override fun shortage(): Single<Result<List<StorageData>>> =
            repository.storageData().toResult()

        override fun singleDelete(data: TrackData): Single<Result<Unit>> =
            repository.singleDelete(data).toSingleResult()


        override fun allDelete(): Single<Result<Unit>> =
            repository.allDelete().toSingleResult()

    }