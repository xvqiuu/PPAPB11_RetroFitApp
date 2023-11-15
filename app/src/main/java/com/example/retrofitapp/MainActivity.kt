package com.example.retrofitapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.model.Data
import com.example.retrofitapp.model.Teams
import com.example.retrofitapp.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllTeams()
        val teamList = ArrayList<String>()

        response.enqueue(object : Callback<Teams> {
            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                for(i in response.body()!!.data){
                    teamList.add(i.id.toString())
                    teamList.add(i.name)
                    teamList.add(i.division)
                    teamList.add(i.city)
                }

                with(binding){
                    rvTeams.apply {
                        adapter = TeamAdapter(response.body()!!.data)
                        layoutManager = LinearLayoutManager(context)
                    }
                }
            }

            override fun onFailure(call: Call<Teams>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Koneksi error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}

