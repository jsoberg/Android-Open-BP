package com.soberg.openbp.data

/** Visit [mayoclinic.org](https://www.mayoclinic.org/diseases-conditions/high-blood-pressure/expert-answers/pulse-pressure/faq-20058189)
 * for further information about blood pressure readings. */
data class BpReading(
    /** The top/first number in a blood pressure reading, indicating the maximum pressure your heart exerts while beating.
     * Calculated as a value in millimeters of mercury (mm Hg). */
    val systolic: Short,
    /** The bottom/second number in a blood pressure reading, indicating the amount of pressure in your arteries between beats.
     * Calculated as a value in millimeters of mercury (mm Hg). */
    val diastolic: Short,
    /** The time when this reading was recorded, in milliseconds since the Unix epoch. */
    val recordedTime: Long
)
