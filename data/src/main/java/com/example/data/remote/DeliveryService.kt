package com.example.data.remote

import com.example.data.remote.entity.CarrierData
import com.example.data.remote.entity.DeliveryProgressData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryService {
    @GET
    fun getCourierServiceName() : Single<List<CarrierData>>

    @GET("{carrier_id}/tracks/{track_id}")
    fun getDeliveryProgress(
        @Path("carrier_id") carrierId : String,
        @Path("track_id") trackId : String
    ) : Single<DeliveryProgressData>
}