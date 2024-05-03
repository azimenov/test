package com.example.test.network

import com.example.test.models.AlbumModel
import retrofit2.Call
import retrofit2.http.GET

interface SomeAPI {
    @GET("/albums")
    fun getData(): Call<List<AlbumModel>>
}