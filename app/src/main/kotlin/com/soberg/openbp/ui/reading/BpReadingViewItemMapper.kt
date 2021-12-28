package com.soberg.openbp.ui.reading

import com.soberg.openbp.domain.classification.Classifier
import com.soberg.openbp.domain.reading.BpReading

class BpReadingViewItemMapper(
    private val classifier: Classifier
) {
    fun map(readings: List<BpReading>): List<BpReadingViewItem> =
        readings.map { reading ->
            BpReadingViewItem(
                id = reading.id!!,
                systolic = reading.systolic,
                diastolic = reading.diastolic,
                classification = classifier.classify(reading)
            )
        }
}