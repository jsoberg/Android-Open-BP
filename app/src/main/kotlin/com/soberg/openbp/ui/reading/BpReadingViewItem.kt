package com.soberg.openbp.ui.reading

import com.soberg.openbp.domain.classification.Classification
import com.soberg.openbp.domain.reading.Pressure

data class BpReadingViewItem(
    val id: Long,
    val systolic: Pressure,
    val diastolic: Pressure,
    val classification: Classification
)