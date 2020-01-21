package com.app.base.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.app.base.room.entity.ContactData
import com.app.base.room.entity.FactData

/**
 * After adding the suspension, our Dao class methods can execute without blocking the current thread.
 */
@Dao
interface FactDao {
    @Query("SELECT * from factData")
    fun getAllFact(): LiveData<MutableList<FactData>>


    @Query("SELECT * from factData")
    suspend fun getAllFact2(): List<FactData>

    @Insert(onConflict = REPLACE)
    suspend fun insertFact(factData: FactData)

    @Query("delete from factData where fact=:factToDelete")
    suspend fun deleteFact(factToDelete: String): Void


    @Query("delete from factData")
    suspend fun deleteAllFact(): Void

    @Query("UPDATE factData SET save_status=:status WHERE id=:id")
    suspend fun markFactAsFav(status: Boolean, id: Int)

    @Query("SELECT * FROM factData where save_status=:status")
    suspend fun getFavFacts(status: Boolean): List<FactData>



}