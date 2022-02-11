package com.soberg.openbp.domain.reading

/** Pressure, in millimeters mercury (mmHg). */
@JvmInline
value class Pressure private constructor(val mmHg: Short) {

    companion object {
        val Short.mmHg: Pressure get() = Pressure(mmHg = this)
        val Int.mmHg: Pressure get() = Pressure(mmHg = this.toShort())
    }

    override fun toString(): String = mmHg.toString()

    operator fun compareTo(other: Pressure) = (mmHg - other.mmHg)
}