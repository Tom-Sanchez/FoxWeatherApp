package com.example.foxweatherapp.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.foxweatherapp.R
import com.example.foxweatherapp.data.model.Weather

class CurrentWeatherItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val localisationTextView: TextView
    private val dayTextView: TextView
    private val weatherDescriptionTextView: TextView
    private val feelsLikeTextView: TextView
    private val windTextView: TextView
    private val humidityTextView: TextView
    private val temperatureTextView: TextView
    private val skyImg: ImageView

    init {
        inflate(context, R.layout.item_current_weather, this)
        localisationTextView = findViewById(R.id.localisationTv)
        dayTextView = findViewById(R.id.dayTv)
        weatherDescriptionTextView = findViewById(R.id.weatherDescriptionTv)
        feelsLikeTextView = findViewById(R.id.feelsLikeTv)
        windTextView = findViewById(R.id.windTv)
        humidityTextView = findViewById(R.id.humidityTv)
        temperatureTextView = findViewById(R.id.temperatureTv)
        skyImg = findViewById(R.id.skyImg)
    }

    fun setWeather(weather: Weather) {
        with(weather) {
            localisationTextView.text = localisation
            dayTextView.text = context.getString(R.string.day_time_display, day, time)
            weatherDescriptionTextView.text = weatherDescription
            feelsLikeTextView.text = context.getString(R.string.feels_like_display, temperatureFeelsLike, degType)
            humidityTextView.text = "${context.getString(R.string.humidity_display, humidity)}%"
            windTextView.text = context.getString(R.string.wind_display, wind)
            temperatureTextView.text = context.getString(R.string.temperature_display, temperature, degType)
            //setSkyImage(skyCode)
        }
    }

//    private fun setSkyImage(code: String? = null) {
//        val imageViewTarget : Glide
//        Glide.with(context)
//            .asGif()
//            .load("http://blob.weather.microsoft.com/static/weather4/en-us/law/$code.gif")
//            .centerCrop()
//            .into(DrawableIm)
//    }
}