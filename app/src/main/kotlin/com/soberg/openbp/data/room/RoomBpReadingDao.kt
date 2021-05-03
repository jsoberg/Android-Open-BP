package com.soberg.openbp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface RoomBpReadingDao {
    @Query("SELECT * FROM ${RoomBpReading.TABLE_NAME}")
    fun getAll(): List<RoomBpReading>

    @Query("SELECT * FROM ${RoomBpReading.TABLE_NAME} WHERE ${RoomBpReading.ID} = :id")
    fun loadById(id: Long): RoomBpReading

    @Delete
    fun delete(reading: RoomBpReading)
}