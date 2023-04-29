package com.example.foxweatherapp.ui

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.foxweatherapp.R
import com.example.foxweatherapp.databinding.ActivityMainBinding
import com.example.foxweatherapp.ui.adapter.ViewPagerAdapter
import com.example.foxweatherapp.utils.hideKeyboard
import com.example.foxweatherapp.viewmodels.WeatherViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

val titleArrays = arrayOf(
    R.string.current,
    R.string.forecast
)

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun inflate(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.button.setOnClickListener {
            val query = binding.searchView.query.toString()
            weatherViewModel.loadCurrentWeather(query)

            hideKeyboard()
        }

        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getString(titleArrays[position])
        }.attach()
    }
}