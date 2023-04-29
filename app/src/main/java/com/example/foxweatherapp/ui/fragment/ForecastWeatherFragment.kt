package com.example.foxweatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foxweatherapp.data.model.ForecastWeather
import com.example.foxweatherapp.databinding.FragmentForecastWeatherBinding
import com.example.foxweatherapp.ui.adapter.RecyclerViewAdapter

class ForecastWeatherFragment : WeatherFragment<FragmentForecastWeatherBinding>() {

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentForecastWeatherBinding {
        return FragmentForecastWeatherBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadedForecastWeather.observe(viewLifecycleOwner) {
            when(it) {
                is com.example.foxweatherapp.utils.Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is com.example.foxweatherapp.utils.Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    setupRecyclerView(it.value.toMutableList())
                }
                is com.example.foxweatherapp.utils.Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    showErrorToast(it.exception.message)
                }
            }
        }
    }

    private fun setupRecyclerView(items: MutableList<ForecastWeather>) {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2)
            adapter = RecyclerViewAdapter(items)
        }
    }
}