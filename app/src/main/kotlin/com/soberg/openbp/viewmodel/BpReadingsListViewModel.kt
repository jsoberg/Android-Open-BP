package com.soberg.openbp.viewmodel

import androidx.lifecycle.ViewModel
import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.BpReadingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BpReadingsListViewModel @Inject constructor(
    private val repository: BpReadingRepository
) : ViewModel() {

    // TODO this will be Observable once I decide whether to use RxJava or Flows etc., but just return static data to test the view for now.
    fun getState() = repository.getAll()
        .map { readings ->
            State(
                isLoading = false,
                readings = readings
            )
        }

    data class State(
        val isLoading: Boolean,
        val readings: List<BpReading>
    )
}