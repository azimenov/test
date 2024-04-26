package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllData()
    }

    private fun getAllData() {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(SomeAPI::class.java)
        service.getData().enqueue(object : Callback<List<AlbumModel>> {
            override fun onResponse(
                call: Call<List<AlbumModel>>,
                response: Response<List<AlbumModel>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()

                    if (data != null) {
                        Log.d("data", data.toString())
                    } else {
                        Log.e("API Response", "Response body is null")
                    }
                } else {
                    Log.e("API Response", "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                Log.e("API Failure", "Failed to fetch data: ${t.message}")
            }
        })
    }
}