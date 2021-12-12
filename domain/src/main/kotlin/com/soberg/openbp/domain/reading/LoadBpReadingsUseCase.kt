package com.soberg.openbp.domain.reading

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadBpReadingsUseCase @Inject constructor(
    private val repository: BpReadingRepository,
) {
    fun loadBpReadings(): Flow<List<BpReading>> = repository.getAll()
}