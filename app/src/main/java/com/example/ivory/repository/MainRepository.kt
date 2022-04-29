package com.example.ivory.repository

import com.example.ivory.network.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainRepository() : BaseRepository() {
    private suspend fun handleNetworkError(response: suspend () -> Any?): Pair<NetworkErrorModel?, Any?> {
        val networkErrorModel = NetworkErrorModel()
        var data: Pair<NetworkErrorModel?, Any?> = Pair(null, null)
        try {
            networkErrorModel.errorMessage = "success"
            networkErrorModel.statusCode = NetworkResponse.SUCCESS
            data = Pair(networkErrorModel, response())
        } catch (e: Exception) {
            networkErrorModel.errorMessage = e.message
            networkErrorModel.statusCode = NetworkResponse.FAIL
            data = Pair(networkErrorModel, null)
        }
        return data
    }

    suspend fun getList(): Pair<NetworkErrorModel?, Any?> {
        val data = handleNetworkError {
            apiService.getUser()
        }
        return data
    }
}