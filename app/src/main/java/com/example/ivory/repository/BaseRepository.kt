package com.example.ivory.repository

import com.example.ivory.network.RetrofitClient

open class BaseRepository() {
    val apiService = RetrofitClient().apiService
}