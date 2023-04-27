package com.example.foxweatherapp.utils

sealed class Result<out T> {
    class Loading<out T>(val value: T? = null) : Result<T>()
    class Success<out T>(val value: T) : Result<T>()
    class Failure<out T>(val exception: Throwable) : Result<T>()
}