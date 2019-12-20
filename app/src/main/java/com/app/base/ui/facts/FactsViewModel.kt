package com.app.base.ui.facts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.app.base.room.database.FactDatabase
import com.app.base.room.entity.FactData
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * This is the part of lifecycle library;
 * this will help you to provide data between repository and UI.
 * This survives the data on configuration changes and gets the existing ViewModel to reconnect
 * with the new instance of the owner.
 */
class FactsViewModel(application: Application) : AndroidViewModel(application) {

    val repository: FactsRepository
    val allFacts: LiveData<MutableList<FactData>>

    val facts = MediatorLiveData<List<FactData>>()

    val favFacts = MediatorLiveData<List<FactData>>()

    init {
        val factDao = FactDatabase.getInstance(application)!!.factDao()
        repository = FactsRepository(factDao)
        allFacts = repository.allFacts
    }

    fun insert(data: FactData) = viewModelScope.launch {
        repository.insert(data)
    }

    fun getAllFacts() = viewModelScope.launch {
        facts.postValue(repository.getAllFacts())
    }

    fun markFactAsFav(status: Boolean, id: Int) = viewModelScope.launch {
        repository.markFactAsFav(status, id)
    }

    fun getFavFacts() = viewModelScope.launch {
        favFacts.postValue(repository.getFavFacts())
    }

}