package com.example.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name")
    var name : String
)
