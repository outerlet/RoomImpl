package com.example.roomimpl.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomimpl.db.PrefectureRepository
import com.example.roomimpl.db.Prefecture
import kotlinx.coroutines.launch

class PrefectureViewModel : ViewModel() {
    val prefectures = MutableLiveData<List<Prefecture>>()

    fun getPrefectures(context: Context) {
        viewModelScope.launch {
            prefectures.value = PrefectureRepository(context).getAllPrefectures()
        }
    }

    fun addPrefecture(context: Context, prefecture: Prefecture) {
        viewModelScope.launch {
            val repo = PrefectureRepository(context)
            repo.addPrefecture(prefecture)
            prefectures.value = repo.getAllPrefectures()
        }
    }

    fun removePrefecture(context: Context, prefecture: Prefecture) {
        viewModelScope.launch {
            val repo = PrefectureRepository(context)
            repo.removePrefecture(prefecture)
            prefectures.value = repo.getAllPrefectures()
        }
    }
}