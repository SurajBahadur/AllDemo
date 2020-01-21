package com.app.base.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactData")
data class ContactData(@ColumnInfo(name = "contact_name") var ContactName: String,
                       @PrimaryKey @ColumnInfo(name = "contact_number") var ContactNumber: String)