package com.example.foxweatherapp.di

import com.example.foxweatherapp.data.remote.ApiService
import com.example.foxweatherapp.data.remote.RetrofitClient
import com.example.foxweatherapp.data.repository.WeatherRepository
import com.example.foxweatherapp.data.repository.WeatherRepositoryImpl
import com.example.foxweatherapp.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainModule = module {
    single { RetrofitClient(get()).provide(ApiService.BASE_URL) }
    single { get<Retrofit>().create(ApiService::class.java) }
    factory<WeatherRepository> {
        WeatherRepositoryImpl(get())
    }
    viewModel { WeatherViewModel(get()) }
}
