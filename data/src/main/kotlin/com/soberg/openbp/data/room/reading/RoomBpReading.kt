package com.soberg.openbp.data.room.reading

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soberg.openbp.data.room.reading.RoomBpReading.Companion.TABLE_NAME
import com.soberg.openbp.domain.Time
import com.soberg.openbp.domain.reading.BpReading
import com.soberg.openbp.domain.reading.Pressure.Companion.mmHg
import com.soberg.openbp.domain.reading.Pulse.Companion.bpm

@Entity(tableName = TABLE_NAME)
internal data class RoomBpReading(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = SYSTOLIC) val systolic: Short,
    @ColumnInfo(name = DIASTOLIC) val diastolic: Short,
    @ColumnInfo(name = RECORDED_TIME) val recordedTimeMs: Long,
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

    fun toDataModel() = BpReading(
        id = id,
        systolic = systolic.mmHg,
        diastolic = diastolic.mmHg,
        recordedTime = Time.fromMs(recordedTimeMs),
        pulse = pulse?.bpm,
    )
}

internal fun BpReading.toRoomModel() = RoomBpReading(
    id = id ?: 0L,
    systolic = systolic.mmHg,
    diastolic = diastolic.mmHg,
    recordedTimeMs = recordedTime.ms,
    pulse = pulse?.bpm,
)