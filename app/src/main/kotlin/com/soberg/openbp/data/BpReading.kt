package com.soberg.openbp.data

/** Visit [mayoclinic.org](https://www.mayoclinic.org/diseases-conditions/high-blood-pressure/expert-answers/pulse-pressure/faq-20058189)
 * for further information about blood pressure readings. */
data class BpReading(
    /** The top/first number in a blood pressure reading, indicating the maximum pressure your heart exerts while beating. */
    val systolic: Pressure,
    /** The bottom/second number in a blood pressure reading, indicating the amount of pressure in your arteries between beats. */
    val diastolic: Pressure,
    /** The time when this reading was recorded, in milliseconds since the Unix epoch. */
    val recordedTime: Long,

    /** Optional pulse rate corresponding to this blood pressure reading. */
    val pulse: Pulse? = null
)

/** Pulse rate, in beats per minute (bpm). */
inline class Pulse(private val bpm: Short) {
    override fun toString(): String = bpm.toString()
}

/** Pressure, in millimeters mercury (mmHg). */
inline class Pressure(private val mmHg: Short) {
    override fun toString(): String = mmHg.toString()
}
