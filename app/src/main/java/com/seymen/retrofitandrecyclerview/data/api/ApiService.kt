package com.seymen.retrofitandrecyclerview.data.api

import com.seymen.retrofitandrecyclerview.data.model.MarsModel
import retrofit2.http.GET

interface ApiService {

        @GET("realestate")
        suspend fun getMarsLandInfo(): List<MarsModel>

}