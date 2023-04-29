package com.example.foxweatherapp.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(code: String?) {
    Glide.with(context)
        .asGif()
        .load("https://blob.weather.microsoft.com/static/weather4/en-us/law/$code.gif")
        .centerCrop()
        .into(this)
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}