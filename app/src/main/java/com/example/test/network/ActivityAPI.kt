package com.example.test.network

import com.example.test.models.ActivityModel
import retrofit2.http.GET

interface ActivityAPI {
    @GET("activity")
    suspend fun getActivity(): ActivityModel
}