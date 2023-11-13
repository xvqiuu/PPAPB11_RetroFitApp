package com.example.retrofitapp.retrofit

import com.example.retrofitapp.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("hospitals")
    fun getAllUsers() : Call<Users>
}