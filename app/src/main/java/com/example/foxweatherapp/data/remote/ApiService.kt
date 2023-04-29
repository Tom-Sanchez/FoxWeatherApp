package com.example.foxweatherapp.data.remote

import com.example.foxweatherapp.data.model.ForecastWeather
import com.example.foxweatherapp.data.model.Weather
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://thisdavej.azurewebsites.net/api/weather/"
    }

    @GET("current")
    fun getCurrentWeather(
        @Query("loc") loc: String?,
        @Query("deg") deg: String?
    ): Observable<Weather>

    @GET("forecast")
    fun getForecastWeather(
        @Query("loc") loc: String?,
        @Query("deg") deg: String?
    ): Observable<List<ForecastWeather>>
}