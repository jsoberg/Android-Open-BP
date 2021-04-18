package com.soberg.openbp.viewmodel

import com.soberg.openbp.data.BpReading

class BpReadingsListViewModel {

    // TODO this will be Observable once I decide whether to use RxJava or Flows etc., but just return static data to test the view for now.
    fun getState() = State(
        readings = listOf(
            BpReading(systolic = 110, diastolic = 60, recordedTime = 0),
            BpReading(systolic = 120, diastolic = 70, recordedTime = 0),
            BpReading(systolic = 130, diastolic = 80, recordedTime = 0),
        )
    )

    data class State(
        val readings: List<BpReading>
    )
}