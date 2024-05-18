package com.example.test.network

import com.example.test.models.ActivityModel
import com.example.test.models.Joke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    suspend fun getJokeList(): List<Joke> {
        val retrofit = Retrofit.Builder().baseUrl("https://official-joke-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(JokeAPI::class.java)
        return service.getData()
    }

    suspend fun getActivity(): ActivityModel{
        val retrofit = Retrofit.Builder().baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ActivityAPI::class.java)
        return service.getActivity()
    }

    suspend fun getRandomJoke(): Joke {
        val retrofit = Retrofit.Builder().baseUrl("https://official-joke-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(JokeAPI::class.java)
        return service.getRandomJoke()
    }
}