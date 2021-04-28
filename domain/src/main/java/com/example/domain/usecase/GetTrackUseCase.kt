package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.TrackData
import com.example.domain.service.DeliveryService
import io.reactivex.Single

class GetTrackUseCase(
    private val service: DeliveryService
):UseCase<Unit,Result<List<TrackData>>>() {
    override fun create(data: Unit): Single<Result<List<TrackData>>> =
         service.getTrackData()
}