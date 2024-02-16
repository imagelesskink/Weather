package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.data.di.networkModule
import com.example.weatherapp.data.di.repositoryModule
import com.example.weatherapp.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }

}