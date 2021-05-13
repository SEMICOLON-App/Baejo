package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.StorageData
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class StorageUseCase(
    private val service: DeliveryService
) : UseCase<Unit, Result<List<StorageData>>>() {
    override fun create(data: Unit): Single<Result<List<StorageData>>> =
        service.shortage()
}