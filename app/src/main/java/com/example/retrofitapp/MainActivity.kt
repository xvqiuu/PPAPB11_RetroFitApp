package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.model.Users
import com.example.retrofitapp.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllUsers()

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                val names = arrayListOf<String>()
                for (data in response.body()?.data ?: arrayListOf()){
                    names.add(data.name)
                }
                val adapter = ArrayAdapter (
                    this@MainActivity,
                    android.R.layout.simple_list_item_1,
                    names
                )
                binding.lsView.adapter = adapter
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {

            }

        }
        )
    }
}