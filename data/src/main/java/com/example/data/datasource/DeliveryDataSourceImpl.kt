package com.example.data.datasource

import com.example.data.local.dao.SearchHistoryDao
import com.example.data.local.entity.SearchHistoryEntity
import com.example.data.remote.DeliveryService
import com.example.data.remote.entity.CarrierEntityData
import com.example.data.remote.entity.DeliveryInformationEntityData
import com.example.data.remote.entity.DeliveryProgressData
import io.reactivex.Completable
import io.reactivex.Single

class DeliveryDataSourceImpl(
    private val searchHistoryDao: SearchHistoryDao,
    private val deliveryService: DeliveryService
) : DeliveryDataSource {

    override fun getSearchHistoryList(): List<SearchHistoryEntity>  =
        searchHistoryDao.getSearchHistoryList()

    override fun addSearchHistory(searchHistoryEntity: SearchHistoryEntity): Completable  =
        searchHistoryDao.addSearchHistory(searchHistoryEntity)

    override fun deleteSearchHistory(searchHistoryEntity: SearchHistoryEntity): Completable  =
        searchHistoryDao.deleteSearchHistory(searchHistoryEntity)

    override fun deleteAllSearchHistory(): Completable =
        searchHistoryDao.deleteAllSearchHistory()

    override fun getCourierServiceName(): Single<List<CarrierEntityData>> =
        deliveryService.getCourierServiceName()

    override fun getDeliveryProgress(deliveryInformationEntityData: DeliveryInformationEntityData): Single<DeliveryProgressData> =
        deliveryService.getDeliveryProgress(deliveryInformationEntityData.courierServiceId,deliveryInformationEntityData.waybillNumber)
    
}