package com.soberg.openbp.domain.classification

import com.soberg.openbp.domain.reading.BpReading

interface Classifier {

    /** Classifies the provided [reading] into a [Classification], according to this specific classifier.*/
    fun classify(reading: BpReading): Classification
}