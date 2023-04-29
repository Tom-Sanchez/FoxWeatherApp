package com.example.foxweatherapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.foxweatherapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoxWeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        startKoin {
            androidContext(this@FoxWeatherApp)
            modules(mainModule)
        }
    }

}