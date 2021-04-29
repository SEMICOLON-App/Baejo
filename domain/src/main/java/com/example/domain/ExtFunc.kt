
package com.example.domain

import com.example.domain.base.Result
import io.reactivex.Completable
import io.reactivex.Single

fun <T> Single<T>.toResult() : Single<Result<T>> = this
    .map{
        Result.Success(it)
    }


fun Completable.toSingleResult(): Single<Result<Unit>> = this
    .toSingle{}.toResult()

