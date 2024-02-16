package com.example.weatherapp.data.repository

import android.location.Location
import com.example.weatherapp.domain.model.WeatherResponse
import com.example.weatherapp.data.networking.WeatherApiClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class WeatherRepository(val weatherApiClient: WeatherApiClient) {
    suspend fun getWeatherResponse(
        dispatcher: CoroutineDispatcher,
        value: String
    ): WeatherResponse {
        return withContext(dispatcher) {
            weatherApiClient.api.getWeather(city = value)
        }
    }

    suspend fun getWeatherResponseByLocation(
        dispatcher: CoroutineDispatcher,
        location: Location
    ): WeatherResponse {
        return withContext(dispatcher) {
            weatherApiClient.api.getWeatherByLocation(
                location.latitude,
                location.longitude
            )
        }
    }
}