package com.example.ivory.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ivory.models.Todo
import com.example.ivory.network.NetworkResponse
import com.example.ivory.repository.MainRepository
import com.example.ivory.repository.NetworkErrorModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel() : ViewModel() {
    val data: MutableLiveData<String?> = MutableLiveData()
    private val mainRepository = MainRepository()
    fun getList() {
        GlobalScope.launch() {
            val result = mainRepository.getList()
            Log.d("test2x", "result: ${result}")
            when (result.first?.statusCode) {
                NetworkResponse.SUCCESS -> {
                    val response = result.second as Todo?
                    data.postValue(response?.title)
                }
                NetworkResponse.FAIL -> {
                    data.postValue("API FAILED: ${result.first?.errorMessage}")
                }
            }
        }
    }
}