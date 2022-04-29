package com.example.ivory.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        @JvmStatic
        private fun getRetrofitInstance(): Retrofit {
            var retrofit: Retrofit? = null
            if (retrofit == null) {
                retrofit = Retrofit
                    .Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
            }
            return retrofit!!
        }
    }
    public val apiService = getRetrofitInstance().create(ApiClient::class.java)
}