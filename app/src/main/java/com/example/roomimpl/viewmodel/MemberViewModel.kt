package com.example.roomimpl.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomimpl.db.PrefectureRepository
import com.example.roomimpl.db.Prefecture
import kotlinx.coroutines.launch

class MemberViewModel : ViewModel() {
    val prefectures = MutableLiveData<List<Prefecture>>()

    fun getPrefectures(context: Context) {
        viewModelScope.launch {
            prefectures.value = PrefectureRepository(context).getAllPrefectures()
        }
    }
}