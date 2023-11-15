package com.example.retrofitapp.retrofit

import com.example.retrofitapp.model.Teams
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("teams")
    fun getAllTeams() : Call<Teams>

}