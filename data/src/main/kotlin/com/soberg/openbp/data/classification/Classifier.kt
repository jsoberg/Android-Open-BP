package com.soberg.openbp.data.classification

import com.soberg.openbp.data.BpReading

interface Classifier {

    /** Classifies the provided [reading] into a [Classification], according to this specific classifier.*/
    fun classify(reading: BpReading): Classification
}