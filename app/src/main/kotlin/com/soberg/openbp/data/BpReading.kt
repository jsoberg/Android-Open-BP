package com.soberg.openbp.data

/** Database-agnostic blood pressure reading data.
 *
 * Visit [mayoclinic.org](https://www.mayoclinic.org/diseases-conditions/high-blood-pressure/expert-answers/pulse-pressure/faq-20058189)
 * for further information about blood pressure readings. */
data class BpReading(
    /** Database ID for this reading, or null if it hasn't been persisted yet. */
    val id: Long? = null,
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

inline val Short.bpm: Pulse get() = Pulse(bpm = this)
inline val Int.bpm: Pulse get() = Pulse(bpm = this.toShort())

/** Pressure, in millimeters mercury (mmHg). */
inline class Pressure(private val mmHg: Short) {
    override fun toString(): String = mmHg.toString()
}

inline val Short.mmHg: Pressure get() = Pressure(mmHg = this)
inline val Int.mmHg: Pressure get() = Pressure(mmHg = this.toShort())