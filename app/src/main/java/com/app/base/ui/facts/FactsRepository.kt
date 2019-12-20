package com.app.base.ui.facts

import androidx.lifecycle.LiveData
import com.app.base.room.dao.FactDao
import com.app.base.room.entity.FactData

/**
 * This is a class where we will check whether to fetch data from API or local database,
 * or you can say we are putting the logic of database fetching in this class.
 */
class FactsRepository(private var factDao: FactDao) {
    val allFacts: LiveData<MutableList<FactData>> = factDao.getAllFact()

    suspend fun insert(fact: FactData) {
        factDao.insertFact(fact)
    }

    suspend fun getAllFacts(): List<FactData> {
        return factDao.getAllFact2()
    }

    suspend fun markFactAsFav(status: Boolean, id: Int) {
        factDao.markFactAsFav(status, id)
    }

    suspend fun getFavFacts(): List<FactData> {
        return factDao.getFavFacts(true)
    }
}