package com.example.domain.service

import com.example.domain.base.Result
import com.example.domain.entity.*
import com.example.domain.repository.DeliveryRepository
import com.example.domain.toResult
import com.example.domain.toSingleResult
import io.reactivex.Single

class DeliveryServiceImpl(
    private val repository: DeliveryRepository
) : DeliveryService {
    override fun getCarrier(): Single<Result<List<CarrierData>>> =
        repository.getCarrier().toResult()

    override fun getDeliveryProgress(
        deliveryBasicInformationData: DeliveryBasicInformationData
    ): Single<Result<List<DeliveryProgress>>> =
        repository.getDeliveryProgress(deliveryBasicInformationData).toResult()

    override fun searchHistory(): Single<Result<List<SearchHistoryData>>> =
        repository.searchHistoryData().toResult()

    override fun deleteSearchHistory(data: DeliveryProgress): Single<Result<Unit>> =
        repository.deleteSearchHistory(data).toSingleResult()

    override fun deleteAllSearchHistory(): Single<Result<Unit>> =
        repository.deleteAllSearchHistory().toSingleResult()
}