package com.example.foxweatherapp

import android.app.Application
import com.example.foxweatherapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoxWeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FoxWeatherApp)
            modules(mainModule)
        }
    }

}