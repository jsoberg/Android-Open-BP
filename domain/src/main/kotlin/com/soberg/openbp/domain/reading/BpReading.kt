package com.soberg.openbp.domain.reading

import com.soberg.openbp.domain.Time

/** Blood pressure reading data.
 *
 * Visit [mayoclinic.org](https://www.mayoclinic.org/diseases-conditions/high-blood-pressure/expert-answers/pulse-pressure/faq-20058189)
 * for further information about blood pressure readings. */
data class BpReading(
    /** ID for this reading, or null if it hasn't been persisted yet. */
    val id: Long? = null,
    /** The top/first number in a blood pressure reading, indicating the maximum pressure your heart exerts while beating. */
    val systolic: Pressure,
    /** The bottom/second number in a blood pressure reading, indicating the amount of pressure in your arteries between beats. */
    val diastolic: Pressure,
    /** The date and time that this reading was recorded. */
    val recordedTime: Time = Time.now,

    /** Optional pulse rate corresponding to this blood pressure reading. */
    val pulse: Pulse? = null
)