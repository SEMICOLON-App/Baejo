package com.example.data.datasource

import com.example.data.local.entity.SearchHistoryEntity
import com.example.data.remote.entity.CarrierEntityData
import com.example.data.remote.entity.DeliveryInformationEntityData
import com.example.data.remote.entity.DeliveryProgressData
import com.example.domain.entity.DeliveryBasicInformationData
import io.reactivex.Completable
import io.reactivex.Single

interface DeliveryDataSource {

    fun getSearchHistoryList() : List<SearchHistoryEntity>

    fun addSearchHistory(searchHistoryEntity: SearchHistoryEntity) : Completable

    fun deleteSearchHistory(searchHistoryEntity: SearchHistoryEntity) : Completable

    fun deleteAllSearchHistory() : Completable

    fun getCourierServiceName() : Single<List<CarrierEntityData>>

    fun getDeliveryProgress(deliveryInformationEntityData: DeliveryInformationEntityData) : Single<DeliveryProgressData>
}