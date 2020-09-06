package com.example.roomimpl.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prefectures")
data class Prefecture(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    @ColumnInfo(name = "name_kana") val nameKana: String
) {
    constructor(name: String, nameKana: String) : this(0, name, nameKana)
}