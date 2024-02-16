package com.example.weatherapp.domain.model

import com.google.gson.annotations.Expose

data class WeatherResponse(
    @Expose
    val base: String,
    @Expose
    val clouds: Clouds,
    @Expose
    val cod: Int,
    @Expose
    val coord: Coord,
    @Expose
    val dt: Int,
    @Expose
    val id: Int,
    @Expose
    val main: Main,
    @Expose
    val name: String,
    @Expose
    val sys: Sys,
    @Expose
    val visibility: Int,
    @Expose
    val weather: List<Weather>,
    @Expose
    val wind: Wind
)

data class Clouds(
    @Expose
    val all: Int
)

data class Coord(
    @Expose
    val lat: Double,
    @Expose
    val lon: Double
)

data class Main(
    @Expose
    val humidity: Int,
    @Expose
    val pressure: Int,
    @Expose
    val temp: Double,
    @Expose
    val temp_max: Double,
    @Expose
    val temp_min: Double
)

data class Sys(
    @Expose
    val country: String,
    @Expose
    val id: Int,
    @Expose
    val message: Double,
    @Expose
    val sunrise: Int,
    @Expose
    val sunset: Int,
    @Expose
    val type: Int
)

data class Weather(
    @Expose
    val description: String,
    @Expose
    val icon: String,
    @Expose
    val id: Int,
    @Expose
    val main: String
)

data class Wind(
    @Expose
    val deg: Int,
    @Expose
    val speed: Double
)