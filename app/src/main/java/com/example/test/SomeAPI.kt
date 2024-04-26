package com.example.test

import retrofit2.Call
import retrofit2.http.GET

interface SomeAPI {

    @GET("/albums")
    fun getData(): Call<List<AlbumModel>>
}