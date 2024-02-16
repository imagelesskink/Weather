package com.example.weatherapp.data.di

import com.example.weatherapp.data.networking.WeatherApiClient
import org.koin.dsl.module

val networkModule = module {
    factory<WeatherApiClient> { WeatherApiClient() }
}