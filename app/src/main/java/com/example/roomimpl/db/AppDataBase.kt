package com.example.roomimpl.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Prefecture::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun prefectureDao(): PrefectureDao
}