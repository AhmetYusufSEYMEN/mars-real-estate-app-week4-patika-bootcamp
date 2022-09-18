package com.seymen.retrofitandrecyclerview.data.remote

import com.seymen.retrofitandrecyclerview.domain.model.MarsModel
import retrofit2.http.GET

interface ApiService {

        @GET("realestate")
        suspend fun getMarsLandInfo(): List<MarsModel>

}