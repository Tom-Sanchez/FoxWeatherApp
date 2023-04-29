package com.example.foxweatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.foxweatherapp.R
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
                    binding.currentWeatherItem.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                is com.example.foxweatherapp.utils.Result.Success -> {
                    binding.currentWeatherItem.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    binding.currentWeatherItem.setWeather(it.value)
                }
                is com.example.foxweatherapp.utils.Result.Failure -> {
                    binding.currentWeatherItem.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                    showErrorToast(it.exception.message)
                }
            }
        }
    }
}