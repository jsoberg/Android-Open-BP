package com.soberg.openbp.viewmodel

import androidx.lifecycle.ViewModel
import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.mmHg

class BpReadingsListViewModel : ViewModel() {

    // TODO this will be Observable once I decide whether to use RxJava or Flows etc., but just return static data to test the view for now.
    fun getState() = State(
        isLoading = false,
        readings = listOf(
            BpReading(systolic = 110.mmHg, diastolic = 60.mmHg, recordedTime = 0),
            BpReading(systolic = 120.mmHg, diastolic = 70.mmHg, recordedTime = 0),
            BpReading(systolic = 130.mmHg, diastolic = 80.mmHg, recordedTime = 0),
        )
    )

    data class State(
        val isLoading: Boolean,
        val readings: List<BpReading>
    )
}