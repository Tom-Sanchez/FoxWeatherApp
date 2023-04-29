package com.example.foxweatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foxweatherapp.R
import com.example.foxweatherapp.data.model.ForecastWeather
import com.example.foxweatherapp.databinding.ItemForecastWeatherBinding
import com.example.foxweatherapp.utils.loadImage

class RecyclerViewAdapter(val items: MutableList<ForecastWeather>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private lateinit var binding: ItemForecastWeatherBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemForecastWeatherBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: ItemForecastWeatherBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(item: ForecastWeather) {
            with(binding) {
                dayTv.text = item.shortDay
                skyImg.loadImage(item.skyCodeDay)
                lowTv.text = itemView.context.getString(R.string.temperature_display, item.low, item.degType)
                highTv.text = itemView.context.getString(R.string.temperature_display, item.high, item.degType)
            }
        }
    }
}