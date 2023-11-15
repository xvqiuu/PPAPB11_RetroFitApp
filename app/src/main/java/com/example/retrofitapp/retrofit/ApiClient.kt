package com.example.retrofitapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getInstance() : ApiService {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
        val builder = Retrofit.Builder()
            .baseUrl("https://api.coinstats.app/public/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return builder.create(ApiService::class.java)

    }
}