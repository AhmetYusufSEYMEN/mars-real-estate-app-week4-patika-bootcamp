package com.seymen.retrofitandrecyclerview.presentation.mars_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seymen.retrofitandrecyclerview.data.remote.ApiHelper
import com.seymen.retrofitandrecyclerview.domain.repository.MainRepository

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarsListViewModel::class.java)) {
            return MarsListViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}