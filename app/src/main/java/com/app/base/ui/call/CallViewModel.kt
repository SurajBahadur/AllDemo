package com.app.base.ui.call

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.app.base.room.database.FactDatabase
import com.app.base.room.entity.ContactData
import kotlinx.coroutines.launch

class CallViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CallRepository
    val allContacts: LiveData<MutableList<ContactData>>
    val contacts = MediatorLiveData<List<ContactData>>()

    init {
        val contactDao = FactDatabase.getInstance(application)!!.contactDao()
        repository = CallRepository(contactDao)
        allContacts = repository.allContact
    }

    fun addContact(data: ContactData) = viewModelScope.launch {
        repository.addContact(data)
    }

    fun getAllContacts() = viewModelScope.launch {
        contacts.postValue(repository.getAllContact())
    }
}