package com.example.test.fragments

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.models.ActivityModel
import com.example.test.models.Joke
import com.example.test.network.ApiClient
import kotlinx.coroutines.launch

class ActivityViewModel : ViewModel() {
    private val _activity = MutableLiveData<ActivityModel>()
    public val activity get() = _activity

    fun getRandomActivity() {
        viewModelScope.launch {
            _activity.postValue(
                ApiClient.getActivity()
            )
        }
    }
}