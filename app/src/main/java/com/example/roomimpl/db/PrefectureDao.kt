package com.example.roomimpl.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PrefectureDao {
    @Query("select * from prefectures")
    fun getAll(): List<Prefecture>

    @Query("select * from prefectures where rowid = :rowId")
    fun getByRowId(rowId: Int): Prefecture

    @Insert
    fun add(vararg prefecture: Prefecture): List<Long>

    @Delete
    fun remove(vararg prefecture: Prefecture)
}