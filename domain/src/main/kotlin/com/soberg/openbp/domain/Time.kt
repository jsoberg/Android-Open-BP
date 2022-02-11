package com.soberg.openbp.domain

@JvmInline
value class Time private constructor(val ms: Long) {

    companion object {
        val now: Time
            get() = Time(System.currentTimeMillis())

        fun fromMs(ms: Long) = Time(ms)
    }
    
}