package com.app.base.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.base.room.dao.FactDao
import com.app.base.room.entity.FactData

@Database(entities = [FactData::class], version = 1, exportSchema = false)
abstract class FactDatabase : RoomDatabase() {
    abstract fun factDao(): FactDao

    companion object {
        private var INSTANCE: FactDatabase? = null
        fun getInstance(context: Context): FactDatabase? {
            if (INSTANCE == null) {
                synchronized(FactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FactDatabase::class.java, "fact.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}