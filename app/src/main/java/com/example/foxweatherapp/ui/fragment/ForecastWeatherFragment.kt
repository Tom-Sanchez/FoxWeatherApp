package com.example.foxweatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foxweatherapp.data.model.Weather
import com.example.foxweatherapp.databinding.FragmentCurrentWeatherBinding
import com.example.foxweatherapp.databinding.FragmentForecastWeatherBinding
import com.example.foxweatherapp.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class ForecastWeatherFragment : WeatherFragment<FragmentForecastWeatherBinding>() {

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentForecastWeatherBinding {
        return FragmentForecastWeatherBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadedCurrentWeather.observe(viewLifecycleOwner) {
            when(it) {
                is com.example.foxweatherapp.utils.Result.Loading -> {

                }
                is com.example.foxweatherapp.utils.Result.Success -> {
                    binding.textView.text = it.value.localisation
                }
                is com.example.foxweatherapp.utils.Result.Failure -> {
                }
            }
        }
    }
}