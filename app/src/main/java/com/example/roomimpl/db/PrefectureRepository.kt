package com.example.roomimpl.db

import android.content.Context
import com.example.roomimpl.db.Prefecture
import com.example.roomimpl.db.PrefectureDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PrefectureRepository(context: Context) {
    private val mDataSource = PrefectureDataSource(context)

    suspend fun getAllPrefectures() =
        withContext(Dispatchers.IO) {
            mDataSource.getAll()
        }

    suspend fun addPrefecture(prefecture: Prefecture) =
        withContext(Dispatchers.IO) {
            mDataSource.add(prefecture)
        }

    suspend fun removePrefecture(prefecture: Prefecture) =
        withContext(Dispatchers.IO) {
            mDataSource.remove(prefecture)
        }
}