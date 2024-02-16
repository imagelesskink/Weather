package com.example.weatherapp.data.di

import com.example.weatherapp.data.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRepository(get()) }
}