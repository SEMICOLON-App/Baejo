package com.example.domain.usecase

import com.example.domain.base.Result
import com.example.domain.base.UseCase
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.InquiryResultData
import com.example.domain.service.DeliveryService
import com.example.domain.toResult
import io.reactivex.Single

class InquiryResultUseCase(
    private val service: DeliveryService
): UseCase<DeliveryBasicInformationData, Result<InquiryResultData>>() {
    override fun create(data: DeliveryBasicInformationData): Single<Result<InquiryResultData>> =
        service.inquiryResult(data)
}
