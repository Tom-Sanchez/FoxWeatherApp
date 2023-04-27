package com.example.foxweatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foxweatherapp.databinding.FragmentCurrentWeatherBinding

class CurrentWeatherFragment : WeatherFragment<FragmentCurrentWeatherBinding>() {

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentCurrentWeatherBinding {
        return FragmentCurrentWeatherBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadedCurrentWeather.observe(viewLifecycleOwner) {
            when(it) {
                is com.example.foxweatherapp.utils.Result.Loading -> {

                }
                is com.example.foxweatherapp.utils.Result.Success -> {

                }
                is com.example.foxweatherapp.utils.Result.Failure -> {
                }
            }
        }
    }
}