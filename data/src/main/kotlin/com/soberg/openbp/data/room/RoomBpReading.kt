package com.soberg.openbp.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soberg.openbp.data.room.RoomBpReading.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class RoomBpReading(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = SYSTOLIC) val systolic: Short,
    @ColumnInfo(name = DIASTOLIC) val diastolic: Short,
    @ColumnInfo(name = RECORDED_TIME) val recordedTime: Long,
    @ColumnInfo(name = PULSE) val pulse: Short?
) {
    companion object {
        const val TABLE_NAME = "blood_pressure_reading"

        const val ID = "id"
        const val SYSTOLIC = "systolic_pressure_mmhg"
        const val DIASTOLIC = "diastolic_pressure_mmhg"
        const val RECORDED_TIME = "recorded_time_ms"
        const val PULSE = "pulse_bpm"
    }
}