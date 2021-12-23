package com.soberg.openbp.domain.reading

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class LoadBpReadingsUseCaseShould {

    private val repository: BpReadingRepository = mockk(relaxed = true)
    private val useCase = LoadBpReadingsUseCase(
        repository = repository
    )

    @Test
    fun `call into the repository to load readings`() {
        useCase.loadBpReadings()
        verify { repository.getAll() }
    }
}