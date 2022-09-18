package com.seymen.retrofitandrecyclerview.data.remote

class ApiHelper(private val apiService: ApiService) {

    suspend fun getMarsLandInfo() = apiService.getMarsLandInfo()
}