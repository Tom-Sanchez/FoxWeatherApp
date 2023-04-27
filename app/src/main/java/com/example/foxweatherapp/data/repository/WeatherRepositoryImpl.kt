package com.example.foxweatherapp.data.repository

import com.example.foxweatherapp.data.model.Weather
import com.example.foxweatherapp.data.remote.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

class WeatherRepositoryImpl(
    private val apiService: ApiService
): WeatherRepository {

    override fun getCurrentWeather(loc: String?, deg: String?): Observable<Weather> {
        return apiService.getCurrentWeather(loc, deg)
    }
}