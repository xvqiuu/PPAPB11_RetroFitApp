package com.example.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("division")
    val division: String,

    @SerializedName("city")
    val city: String

)
