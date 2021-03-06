package com.alanmxll.mysubscribes.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alanmxll.mysubscribes.data.db.entity.SubscriberEntity

@Dao
interface SubscriberDAO {
    @Insert
    suspend fun insert(subscriber: SubscriberEntity): Long

    @Update
    suspend fun update(subscriber: SubscriberEntity)

    @Query(value = "DELETE FROM subscriber WHERE id = :id")
    suspend fun delete(id: Long)

    @Query(value = "DELETE FROM subscriber")
    suspend fun deleteAll()

    @Query(value = "SELECT * FROM subscriber")
    fun getAll(): LiveData<List<SubscriberEntity>>
}