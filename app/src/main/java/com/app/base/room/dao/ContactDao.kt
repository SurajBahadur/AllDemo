package com.app.base.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.base.room.entity.ContactData

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contactData: ContactData)

    @Query("SELECT * FROM contactData")
    fun getAllContact(): LiveData<MutableList<ContactData>>

    @Query("SELECT * FROM contactData WHERE contact_number=:number")
    fun getNumberDetail(number: String): List<ContactData>

    @Query("SELECT * FROM contactData")
    suspend fun getAllContactList(): List<ContactData>


}