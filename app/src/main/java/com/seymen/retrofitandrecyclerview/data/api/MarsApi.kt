package com.seymen.retrofitandrecyclerview.data.api

import com.seymen.retrofitandrecyclerview.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarsApi {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }
    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}