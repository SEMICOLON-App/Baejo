package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class AllDeleteUseCase(
    val service : DeliveryService
): UseCase<Unit, Result<Unit>>() {
    override fun create(data: Unit): Single<Result<Unit>> =
        service.allDelete(data)

}
