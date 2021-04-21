package com.soberg.openbp.viewmodel

import androidx.lifecycle.ViewModel
import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.Pressure

class BpReadingsListViewModel : ViewModel() {

    // TODO this will be Observable once I decide whether to use RxJava or Flows etc., but just return static data to test the view for now.
    fun getState() = State(
        readings = listOf(
            BpReading(systolic = Pressure(110), diastolic = Pressure(60), recordedTime = 0),
            BpReading(systolic = Pressure(120), diastolic = Pressure(70), recordedTime = 0),
            BpReading(systolic = Pressure(130), diastolic = Pressure(80), recordedTime = 0),
        )
    )

    data class State(
        val readings: List<BpReading>
    )
}