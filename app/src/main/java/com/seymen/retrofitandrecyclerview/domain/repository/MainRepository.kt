package com.seymen.retrofitandrecyclerview.domain.repository

import com.seymen.retrofitandrecyclerview.data.remote.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getMarsInfoRepo() = apiHelper.getMarsLandInfo()
}