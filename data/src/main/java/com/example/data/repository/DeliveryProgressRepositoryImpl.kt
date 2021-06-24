package com.example.data.repository

import com.example.data.datasource.DeliveryDataSource
import com.example.data.local.entity.toDataEntity
import com.example.data.local.entity.toEntity
import com.example.data.remote.entity.CarrierEntityData
import com.example.data.remote.entity.toEntity
import com.example.domain.entity.CarrierData
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.DeliveryProgress
import com.example.domain.entity.SearchHistoryData
import com.example.domain.repository.DeliveryRepository
import io.reactivex.Completable
import io.reactivex.Single

class DeliveryProgressRepositoryImpl(
    private val dataSource : DeliveryDataSource
) : DeliveryRepository {
    override fun getCarrier(): Single<List<CarrierData>> =
        dataSource.getCourierServiceName().map { response -> response.map { it.toEntity() } }

    override fun getDeliveryProgress(deliveryBasicInformationData: DeliveryBasicInformationData): Single<DeliveryProgress> =
        dataSource.getDeliveryProgress(deliveryBasicInformationData.toEntity()).map { it.toEntity() }

    override fun searchHistoryData(): Single<List<SearchHistoryData>> =
        Single.just(dataSource.getSearchHistoryList().map { response ->
            response.toEntity()
        })

    override fun deleteSearchHistory(searchHistoryData: SearchHistoryData): Completable =
        dataSource.deleteSearchHistory(searchHistoryData.toDataEntity())

    override fun deleteAllSearchHistory(): Completable =
        dataSource.deleteAllSearchHistory()
}