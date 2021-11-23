package com.soberg.openbp.data.classification

import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.classification.Classification.*
import com.soberg.openbp.data.mmHg
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AhaClassifierShould {

    private val classification = AhaClassifier()

    @Test
    fun `classify normal when sys less than 120 and dia less than 80`() {
        val reading = BpReading(systolic = 119.mmHg, diastolic = 79.mmHg)
        val result = classification.classify(reading)
        assertThat(result).isEqualTo(NORMAL)
    }

    @Test
    fun `classify elevated when sys equal to 120 and dia less than 80`() {
        val reading = BpReading(systolic = 120.mmHg, diastolic = 79.mmHg)
        val result = classification.classify(reading)
        assertThat(result).isEqualTo(ELEVATED)
    }

    @Test
    fun `classify stage 1 when sys less than 120 and dia equal to 80`() {
        val reading = BpReading(systolic = 119.mmHg, diastolic = 80.mmHg)
        val result = classification.classify(reading)
        assertThat(result).isEqualTo(HYPERTENSION_STAGE_1)
    }

    @Test
    fun `classify stage 1 when sys equal to 130 and dia less than 80`() {
        val reading = BpReading(systolic = 130.mmHg, diastolic = 79.mmHg)
        val result = classification.classify(reading)
        assertThat(result).isEqualTo(HYPERTENSION_STAGE_1)
    }
}