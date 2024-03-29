package com.soberg.openbp.domain.classification

import com.soberg.openbp.domain.classification.Classification.*
import com.soberg.openbp.domain.reading.BpReading
import com.soberg.openbp.domain.reading.Pressure.Companion.mmHg

/** Blood pressure classification from the American Heart Association (AHA).
 * See [heart.org](https://www.heart.org/en/health-topics/high-blood-pressure/understanding-blood-pressure-readings) for further information. */
class AhaClassifier : Classifier {

    override fun classify(reading: BpReading): Classification {
        val sys = reading.systolic
        val dia = reading.diastolic
        return when {
            sys > 180.mmHg || dia > 120.mmHg -> HYPERTENSIVE_CRISIS
            sys >= 140.mmHg || dia >= 90.mmHg -> HYPERTENSION_STAGE_2
            sys >= 130.mmHg || dia >= 80.mmHg -> HYPERTENSION_STAGE_1
            sys >= 120.mmHg && dia < 80.mmHg -> ELEVATED
            // Sys < 120 and dia < 80
            else -> NORMAL
        }
    }

}