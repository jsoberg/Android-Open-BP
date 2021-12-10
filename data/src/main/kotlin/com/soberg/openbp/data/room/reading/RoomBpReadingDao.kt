package com.soberg.openbp.data.room.reading

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
internal interface RoomBpReadingDao {
    @Query("SELECT * FROM ${RoomBpReading.TABLE_NAME} ORDER BY ${RoomBpReading.RECORDED_TIME} DESC")
    fun getAll(): Flow<List<RoomBpReading>>

    @Query("SELECT * FROM ${RoomBpReading.TABLE_NAME} WHERE ${RoomBpReading.ID} = :id")
    fun loadById(id: Long): RoomBpReading

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(reading: RoomBpReading): Long

    @Delete
    fun delete(reading: RoomBpReading)
}