package com.app.base.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.base.room.dao.ContactDao
import com.app.base.room.dao.FactDao
import com.app.base.room.entity.ContactData
import com.app.base.room.entity.FactData

@Database(entities = [FactData::class, ContactData::class], version = 2, exportSchema = true)
abstract class FactDatabase : RoomDatabase() {
    abstract fun factDao(): FactDao

    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: FactDatabase? = null
        fun getInstance(context: Context): FactDatabase? {
            if (INSTANCE == null) {
                synchronized(FactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FactDatabase::class.java, "fact.db")
                            .allowMainThreadQueries()
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