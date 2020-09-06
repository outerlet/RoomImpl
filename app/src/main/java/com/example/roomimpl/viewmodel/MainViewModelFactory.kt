package com.example.roomimpl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PrefectureViewModel::class.java)) {
            return PrefectureViewModel() as T
        }
        throw IllegalArgumentException("Invalid view model class")
    }
}