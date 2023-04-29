package com.example.foxweatherapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastWeather(
    @SerializedName("shortday")
    val shortDay: String? = null,
    @SerializedName("skycodeday")
    val skyCodeDay: String? = null,
    @SerializedName("skytextday")
    val skyTextDay: String? = null,
    val low: String? = null,
    val high: String? = null,
    val degType: String? = null
): Parcelable