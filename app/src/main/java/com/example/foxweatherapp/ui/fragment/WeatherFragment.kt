package com.example.foxweatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.foxweatherapp.R
import com.example.foxweatherapp.data.model.Weather
import com.example.foxweatherapp.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

abstract class WeatherFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null

    val binding get() = _binding!!

    protected val viewModel: WeatherViewModel by activityViewModel()

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun showErrorToast(message: String?) {
        Toast.makeText(requireActivity(), message?: getString(R.string.error_occured), Toast.LENGTH_LONG).show()
    }

    abstract fun inflate(inflater: LayoutInflater, container: ViewGroup?): T
}