package com.example.retrofitapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapp.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.extras

        with(binding) {
            descId.text = "Id: ${data?.getInt("id")}"
            descName.text = "Nama Team: ${data?.getString("name")}"
            descDivision.text = "Divisi:  ${data?.getString("division")}"
            descCity.text = "Kota:  ${data?.getString("city")}"

            btnBack.setOnClickListener {
                finish()
            }
        }
    }
}