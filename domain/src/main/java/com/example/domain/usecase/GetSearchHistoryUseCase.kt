package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.SearchHistoryData
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class GetSearchHistoryUseCase(
    private val service: DeliveryService
) : UseCase<Unit, Result<List<SearchHistoryData>>>() {
    override fun create(data: Unit): Single<Result<List<SearchHistoryData>>> =
        service.searchHistory()
}