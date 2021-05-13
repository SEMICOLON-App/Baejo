package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.CarrierData
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class GetCarrierUseCase(
    private val service: DeliveryService
) : UseCase<Unit, Result<List<CarrierData>>>() {
    override fun create(data: Unit): Single<Result<List<CarrierData>>> =
        service.getCarrier()
}