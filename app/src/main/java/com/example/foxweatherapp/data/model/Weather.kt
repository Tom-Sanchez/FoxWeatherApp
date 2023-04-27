package com.example.foxweatherapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    @SerializedName("observationpoint")
    val localisation: String? = null,
    val day: String? = null,
    @SerializedName("observationtime")
    val time: String? = null,
    @SerializedName("skytext")
    val weatherDescription: String? = null,
    val temperature: String? = null,
    @SerializedName("feelslike")
    val temperatureFeelsLike: String? = null,
    val humidity: String? = null,
    @SerializedName("windspeed")
    val wind: String? = null
): Parcelable
