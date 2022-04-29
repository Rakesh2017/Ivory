package com.example.ivory.clients

import com.example.ivory.models.BaseModel
import com.example.ivory.models.GitHubModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiClient {
    @GET("users/rakesh2017/repos")
    fun listRepos(): Call<ArrayList<GitHubModel?>?>?
}