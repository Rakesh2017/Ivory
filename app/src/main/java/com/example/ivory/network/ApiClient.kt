package com.example.ivory.network

import com.example.ivory.models.Todo
import retrofit2.http.GET

interface ApiClient {
    @GET("todo/1")
    suspend fun getUser(): Todo?
}