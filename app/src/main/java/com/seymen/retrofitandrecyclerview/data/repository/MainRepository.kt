package com.seymen.retrofitandrecyclerview.data.repository

import com.seymen.retrofitandrecyclerview.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getMarsInfoRepo() = apiHelper.getMarsLandInfo()
}