package com.example.foxweatherapp.data.repository

import com.example.foxweatherapp.data.model.Weather
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

interface WeatherRepository {

    fun getCurrentWeather(loc: String? = null, deg: String? = "C"): Observable<Weather>
}