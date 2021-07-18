package com.soberg.openbp.data.classification

import com.soberg.openbp.data.BpReading

interface Classification {

    /** Classified the provided [reading] into a [Category], according to this specific classification.*/
    fun classify(reading: BpReading): Category

    /** Typical categories noted in a blood pressure classification. */
    enum class Category {
        NORMAL,
        ELEVATED,
        HYPERTENSION_STAGE_1,
        HYPERTENSION_STAGE_2,
        HYPERTENSIVE_CRISIS,
    }
}