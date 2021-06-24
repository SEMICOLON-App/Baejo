package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.DeliveryProgress
import com.example.domain.entity.SearchHistoryData
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class DeleteSearchHistoryUseCase(
    private val service: DeliveryService
) : UseCase<SearchHistoryData, Result<Unit>>() {
    override fun create(data: SearchHistoryData): Single<Result<Unit>> =
        service.deleteSearchHistory(data)

}