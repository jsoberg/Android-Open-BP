package com.soberg.openbp.domain.reading

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LoadBpReadingsUseCase @Inject constructor(
    private val repository: BpReadingRepository,
    dispatcher: CoroutineDispatcher
) {
    private val useCaseScope = object : CoroutineScope {
        override val coroutineContext: CoroutineContext =
            dispatcher + CoroutineName("LoadBpReadingsUseCase.Coroutine")
    }

    fun loadBpReadings(): Flow<List<BpReading>> = repository.getAll()
}