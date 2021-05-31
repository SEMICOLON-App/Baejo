package com.example.baejo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.baejo.presentation.base.BaseViewModel
import com.example.baejo.presentation.base.SingleLiveEvent
import com.example.domain.base.Result
import com.example.domain.entity.CarrierData
import com.example.domain.entity.SearchHistoryData
import com.example.domain.usecase.DeleteAllSearchHistoryUseCase
import com.example.domain.usecase.DeleteSearchHistoryUseCase
import com.example.domain.usecase.GetCarrierUseCase
import com.example.domain.usecase.GetSearchHistoryUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class MainViewModel(
    private val getCarrierUseCase: GetCarrierUseCase,
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
    private val deleteSearchHistoryUseCase: DeleteSearchHistoryUseCase,
    private val deleteAllSearchHistoryUseCase: DeleteAllSearchHistoryUseCase
) : BaseViewModel() {

    val carrierList = MutableLiveData<List<CarrierData>?>()
    val searchHistoryList = MutableLiveData<List<SearchHistoryData>?>()

    val messageEvent = SingleLiveEvent<String>()
    val emptySearchHistoryEvent = SingleLiveEvent<Unit>()
    val deleteSuccessEvent = SingleLiveEvent<Unit>()

    fun getCarrier() {
        val carrierResult = getCarrierUseCase.create(Unit)

        val disposableSingleObserver =
            object : DisposableSingleObserver<Result<List<CarrierData>>>() {

                override fun onSuccess(t: Result<List<CarrierData>>) {
                    if (t is Result.Success) {

                        if(t.data.isEmpty()) {
                            messageEvent.setValue("택배사 정보를 가져오지 못했습니다")
                            return
                        }

                        carrierList.value = t.data
                    }
                }

                override fun onError(e: Throwable) {
                    messageEvent.setValue("택배사 정보를 가져오지 못했습니다")
                }
            }

        val disposable = carrierResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }

    fun getSearchHistory() {
        val searchHistoryResult = getSearchHistoryUseCase.create(Unit)

        val disposableSingleObserver = object : DisposableSingleObserver<Result<List<SearchHistoryData>>>() {

            override fun onSuccess(t: Result<List<SearchHistoryData>>) {
                if (t is Result.Success) {

                    if(t.data.isEmpty()) {
                        emptySearchHistoryEvent.setValue(Unit)
                        return
                    }

                    searchHistoryList.value = t.data
                }
            }

            override fun onError(e: Throwable) {
                emptySearchHistoryEvent.setValue(Unit)
            }
        }

        val disposable = searchHistoryResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }

    fun deleteSearchHistory(searchHistoryData: SearchHistoryData) {
        val deleteResult = deleteSearchHistoryUseCase.create(searchHistoryData)

        val disposableSingleObserver = object : DisposableSingleObserver<Result<Unit>>() {

            override fun onSuccess(t: Result<Unit>) {
                if(t is Result.Success) deleteSuccessEvent.setValue(Unit)
            }

            override fun onError(e: Throwable) {
                messageEvent.setValue("조회 기록을 삭제하지 못했습니다")
            }
        }

        val disposable = deleteResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }

    fun deleteAllSearchHistory() {
        val deleteResult = deleteAllSearchHistoryUseCase.create(Unit)

        val disposableSingleObserver = object : DisposableSingleObserver<Result<Unit>>() {

            override fun onSuccess(t: Result<Unit>) {
                if(t is Result.Success) deleteSuccessEvent.setValue(Unit)
            }

            override fun onError(e: Throwable) {
                messageEvent.setValue("조회 기록을 삭제하지 못했습니다")
            }
        }

        val disposable = deleteResult
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSingleObserver)

        addDisposable(disposable)
    }
}