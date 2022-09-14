package com.seymen.retrofitandrecyclerview.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seymen.retrofitandrecyclerview.data.api.ApiHelper
import com.seymen.retrofitandrecyclerview.data.repository.MainRepository
import com.seymen.retrofitandrecyclerview.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}