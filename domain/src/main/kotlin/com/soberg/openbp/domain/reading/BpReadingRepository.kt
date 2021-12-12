package com.soberg.openbp.domain.reading

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BpReadingRepository @Inject constructor(
    private val dataSource: BpReadingDataSource
) {
    fun getAll(): Flow<List<BpReading>> = dataSource.getAll()

    /** Insert or update the specified [BpReading].
     * @return The resulting [BpReading] after persistence. */
    suspend fun upsert(reading: BpReading): BpReading = dataSource.upsert(reading)

    suspend fun delete(reading: BpReading): Unit = dataSource.delete(reading)
}