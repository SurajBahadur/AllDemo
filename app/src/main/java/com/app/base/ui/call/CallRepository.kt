package com.app.base.ui.call

import androidx.lifecycle.LiveData
import com.app.base.room.dao.ContactDao
import com.app.base.room.entity.ContactData

class CallRepository(private var contactDao: ContactDao) {

    val allContact: LiveData<MutableList<ContactData>> = contactDao.getAllContact()

    suspend fun addContact(data: ContactData) {
        contactDao.insertContact(data)
    }

    suspend fun getAllContact(): List<ContactData> {
        return contactDao.getAllContactList()
    }

}