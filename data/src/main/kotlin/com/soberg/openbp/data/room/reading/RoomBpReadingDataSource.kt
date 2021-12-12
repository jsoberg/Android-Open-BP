package com.soberg.openbp.data.room.reading

import com.soberg.openbp.domain.reading.BpReading
import com.soberg.openbp.domain.reading.BpReadingDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RoomBpReadingDataSource @Inject constructor(
    private val bpReadingDao: RoomBpReadingDao
) : BpReadingDataSource {

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