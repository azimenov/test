package com.example.test.network

import com.example.test.models.Joke
import retrofit2.http.GET

interface JokeAPI {
    @GET("random_ten")
    suspend fun getData(): List<Joke>

    @GET("random_joke")
    suspend fun getRandomJoke(): Joke
}