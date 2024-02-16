package com.example.weatherapp.data.networking

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiClient {
    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor {
            Log.d("WeatherAPIClient", it)
        }.setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val api: WeatherService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(WeatherService::class.java)
}