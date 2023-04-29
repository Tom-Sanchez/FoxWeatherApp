package com.example.foxweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.foxweatherapp.data.model.ForecastWeather
import com.example.foxweatherapp.data.model.Weather
import com.example.foxweatherapp.data.repository.WeatherRepository
import com.example.foxweatherapp.utils.Result
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(
    private val repository: WeatherRepository
): BaseViewModel() {

    val loadedCurrentWeather : MutableLiveData<Result<Weather>> = MutableLiveData()
    val loadedForecastWeather: MutableLiveData<Result<List<ForecastWeather>>> = MutableLiveData()

    fun loadCurrentWeather(loc: String? = null) {
        repository.getCurrentWeather(loc)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                loadedCurrentWeather.postValue(Result.Loading())
            }.subscribe({
                loadedCurrentWeather.postValue(Result.Success(it))
                loadForecastWeather(loc)
            }, {
                loadedCurrentWeather.postValue(Result.Failure(it))
            }).let { addDisposable(it) }
    }

    fun loadForecastWeather(loc: String? = null) {
        repository.getForecastWeather(loc)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                loadedForecastWeather.postValue(Result.Loading())
            }.subscribe({
                loadedForecastWeather.postValue(Result.Success(it))
            }, {
                loadedForecastWeather.postValue(Result.Failure(it))
            }).let { addDisposable(it) }
    }
}