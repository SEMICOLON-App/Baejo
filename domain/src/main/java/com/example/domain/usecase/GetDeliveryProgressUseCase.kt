package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.DeliveryProgress
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class GetDeliveryProgressUseCase(
    private val service: DeliveryService
) : UseCase<DeliveryBasicInformationData, Result<List<DeliveryProgress>>>() {
    override fun create(data: DeliveryBasicInformationData): Single<Result<List<DeliveryProgress>>> =
        service.getDeliveryProgress(data)
}