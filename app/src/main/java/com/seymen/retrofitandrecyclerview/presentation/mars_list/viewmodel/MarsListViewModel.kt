package com.seymen.retrofitandrecyclerview.presentation.mars_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.seymen.retrofitandrecyclerview.domain.repository.MainRepository
import com.seymen.retrofitandrecyclerview.utils.Resource
import kotlinx.coroutines.Dispatchers

class MarsListViewModel(private val mainRepository: MainRepository) : ViewModel() {
    /**
     * Data is extracted from repository and processed with IO thread. Error message shown if error is received
     */
    fun getMarsInfo() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getMarsInfoRepo()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}