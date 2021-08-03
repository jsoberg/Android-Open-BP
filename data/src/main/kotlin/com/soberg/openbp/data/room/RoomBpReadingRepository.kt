package com.soberg.openbp.data.room

import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.BpReadingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RoomBpReadingRepository @Inject constructor(
    private val bpReadingDao: RoomBpReadingDao
) : BpReadingRepository {
    
    override fun getAll(): Flow<List<BpReading>> =
        bpReadingDao.getAll()
            .map { readings ->
                readings.map { it.toDataModel() }
            }

    override suspend fun upsert(reading: BpReading): BpReading {
        val id = bpReadingDao.upsert(reading.toRoomModel())
        return reading.copy(id = id)
    }

    override suspend fun delete(reading: BpReading) {
        bpReadingDao.delete(reading.toRoomModel())
    }
}