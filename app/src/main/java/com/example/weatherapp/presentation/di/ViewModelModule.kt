package com.example.weatherapp.presentation.di

import com.example.weatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }
}