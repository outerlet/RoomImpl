package com.example.roomimpl.db

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val DATABASE_NAME = "sampledb"

class PrefectureDataSource(context: Context) {
    private val mDatabase = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).build()

    suspend fun getAll() =
        withContext(Dispatchers.IO) {
            mDatabase.prefectureDao().getAll()
        }

    suspend fun add(prefecture: Prefecture) =
        withContext(Dispatchers.IO) {
            mDatabase.prefectureDao().add(prefecture)
        }

    suspend fun remove(prefecture: Prefecture) =
        withContext(Dispatchers.IO) {
            mDatabase.prefectureDao().remove(prefecture)
        }
}