package com.example.weatherapp.presentation.viewmodel

import android.location.Location
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.model.NetworkStateResponse
import com.example.weatherapp.domain.model.WeatherResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _networkResponse: MutableState<NetworkStateResponse?> = mutableStateOf(null)
    val networkResponse = _networkResponse
    var weather: WeatherResponse? = null

    fun makeWeatherRequest(cityName: String) {
        _networkResponse.value = NetworkStateResponse.Loading
        viewModelScope.launch {
            try {
                val response = repository.getWeatherResponse(dispatcher, cityName)
                _networkResponse.value = NetworkStateResponse.Success(response)
                weather = response
            } catch (ex: Exception) {
                _networkResponse.value = NetworkStateResponse.Failure("Network Failed")
            }
        }
    }

    fun makeLocationWeatherRequest(location: Location) {
        _networkResponse.value = NetworkStateResponse.Loading
        viewModelScope.launch {
            try {
                val response = repository.getWeatherResponseByLocation(dispatcher, location)
                _networkResponse.value = NetworkStateResponse.Success(response)
                weather = response
            } catch (ex: Exception) {
                _networkResponse.value = NetworkStateResponse.Failure("Network Failed")
            }
        }
    }

}