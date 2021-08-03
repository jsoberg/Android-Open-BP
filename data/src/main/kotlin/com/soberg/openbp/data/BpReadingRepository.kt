package com.soberg.openbp.data

import com.soberg.openbp.data.room.RoomBpReading
import kotlinx.coroutines.flow.Flow

interface BpReadingRepository {
    fun getAll(): Flow<List<BpReading>>

    /** Insert or update the specified [BpReading].
     * @return The resulting [BpReading] after persistence. */
    suspend fun upsert(reading: BpReading): BpReading

    suspend fun delete(reading: BpReading)
}