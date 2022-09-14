package com.seymen.retrofitandrecyclerview.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getMarsLandInfo() = apiService.getMarsLandInfo()
}