package com.app.base.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factData")
data class FactData(
        @ColumnInfo(name = "fact") var fact: String,
        @ColumnInfo(name = "save_status") var saveStatus: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
    /*@Entity(tableName = "movie_items")
    data class MovieEntity(
            @ColumnInfo(name = "title") var title: String,
            @ColumnInfo(name = "year") var year: Int
    ) {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
    }*/
}