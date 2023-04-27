package com.example.foxweatherapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foxweatherapp.ui.fragment.CurrentWeatherFragment
import com.example.foxweatherapp.ui.fragment.ForecastWeatherFragment


private const val NUM_TABS = 2
class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CurrentWeatherFragment()
            else -> ForecastWeatherFragment()
        }
    }
}