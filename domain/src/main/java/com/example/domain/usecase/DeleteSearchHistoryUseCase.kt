package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.TrackData
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class DeleteSearchHistoryUseCase(
    private val service: DeliveryService
) : UseCase<TrackData, Result<Unit>>() {
    override fun create(data: TrackData): Single<Result<Unit>> =
        service.deleteSearchHistory(data)

}