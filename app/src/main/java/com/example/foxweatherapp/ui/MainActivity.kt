package com.example.foxweatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foxweatherapp.R
import com.example.foxweatherapp.databinding.ActivityMainBinding
import com.example.foxweatherapp.ui.adapter.ViewPagerAdapter
import com.example.foxweatherapp.viewmodels.WeatherViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

val titleArrays = arrayOf(
    "current",
    "forecast"
)

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun inflate(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.button.setOnClickListener {
            weatherViewModel.loadCurrentWeather(binding.searchView.query.toString())
        }

        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titleArrays[position]
        }.attach()
    }
}