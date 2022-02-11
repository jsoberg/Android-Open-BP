package com.soberg.openbp.domain.reading

/** Pulse rate, in beats per minute (bpm). */
@JvmInline
value class Pulse private constructor(val bpm: Short) {

    companion object {
        val Short.bpm: Pulse get() = Pulse(bpm = this)
        val Int.bpm: Pulse get() = Pulse(bpm = this.toShort())
    }

    override fun toString(): String = bpm.toString()
}