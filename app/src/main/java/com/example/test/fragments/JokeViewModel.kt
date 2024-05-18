package com.example.test.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.models.Joke
import com.example.test.network.ApiClient
import kotlinx.coroutines.launch

class JokeViewModel: ViewModel() {
    private val _jokes = MutableLiveData<List<Joke>>()
    public val jokes get() = _jokes

    fun getJokeList(){
        viewModelScope.launch {
            _jokes.postValue(ApiClient.getJokeList())
        }
    }
}