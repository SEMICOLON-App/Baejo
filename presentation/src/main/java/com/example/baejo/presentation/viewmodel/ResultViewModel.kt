package com.example.baejo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.baejo.presentation.base.BaseViewModel
import com.example.baejo.presentation.base.SingleLiveEvent
import com.example.domain.base.Result
import com.example.domain.entity.DeliveryBasicInformationData
import com.example.domain.entity.DeliveryProgress
import com.example.domain.usecase.GetDeliveryProgressUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ResultViewModel(
    private val getDeliveryProgressUseCase: GetDeliveryProgressUseCase
) : BaseViewModel() {

    val deliveryProgress = MutableLiveData<DeliveryProgress?>()

    val successEvent = SingleLiveEvent<Unit>()
    val failEvent = SingleLiveEvent<String>()

    fun getDeliveryProgress(courierName: String, waybillNumber: String) {
        val deliveryProgressResult = getDeliveryProgressUseCase
            .create(DeliveryBasicInformationData(courierName, waybillNumber))

        val disposableSingleObserver =
            object : DisposableSingleObserver<Result<DeliveryProgress>>() {

                override fun onSuccess(t: Result<DeliveryProgress>) {
                    if (t is Result.Success) {

                        if (t.data.deliveryInformation.isEmpty()) {
                            failEvent.setValue("택배사와 운송장 번호를 확인해주세요")
                            return;
                        };

                        deliveryProgress.value = t.data
                        successEvent.setValue(Unit)
                    }
                }

                override fun onError(e: Throwable) {
                    failEvent.setValue("오류가 발생했습니다")
                }
            }

        val disposable = deliveryProgressResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }
}