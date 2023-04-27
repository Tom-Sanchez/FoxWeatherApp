package com.example.foxweatherapp.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.foxweatherapp.data.model.Weather
import com.example.foxweatherapp.data.repository.WeatherRepository
import com.example.foxweatherapp.utils.Result
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(
    private val repository: WeatherRepository
): BaseViewModel() {

    val loadedCurrentWeather : MutableLiveData<Result<Weather>> = MutableLiveData()

    fun loadCurrentWeather(loc: String? = null) {
        repository.getCurrentWeather(loc)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                loadedCurrentWeather.postValue(Result.Loading())
            }.subscribe({
                loadedCurrentWeather.postValue(Result.Success(it))
            }, {
                loadedCurrentWeather.postValue(Result.Failure(it))
            }).let { addDisposable(it) }
    }
}