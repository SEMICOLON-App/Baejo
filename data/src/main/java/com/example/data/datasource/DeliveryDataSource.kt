package com.example.data.datasource

import com.example.data.local.entity.SearchHistoryEntity
import com.example.data.remote.entity.CarrierData
import com.example.data.remote.entity.DeliveryProgressData
import io.reactivex.Completable
import io.reactivex.Single

interface DeliveryDataSource {

    fun getSearchHistoryList(searchHistoryEntity: SearchHistoryEntity) : List<SearchHistoryEntity>

    fun addSearchHistory(searchHistoryEntity: SearchHistoryEntity) : Completable

    fun deleteSearchHistory(searchHistoryEntity: SearchHistoryEntity) : Completable

    fun deleteAllSearchHistory() : Completable

    fun getCourierServiceName() : Single<List<CarrierData>>

    fun getDeliveryProgress() : Single<DeliveryProgressData>
}