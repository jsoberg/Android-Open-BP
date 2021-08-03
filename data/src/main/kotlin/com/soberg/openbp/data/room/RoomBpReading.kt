package com.soberg.openbp.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.bpm
import com.soberg.openbp.data.mmHg
import com.soberg.openbp.data.room.RoomBpReading.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
internal data class RoomBpReading(
    @PrimaryKey(autoGenerate = true) val id: Long,
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

    fun toDataModel() = BpReading(
        id = id,
        systolic = systolic.mmHg,
        diastolic = diastolic.mmHg,
        recordedTime = recordedTime,
        pulse = pulse?.bpm,
    )
}

internal fun BpReading.toRoomModel() = RoomBpReading(
    id = id ?: 0L,
    systolic = systolic.mmHg,
    diastolic = diastolic.mmHg,
    recordedTime = recordedTime,
    pulse = pulse?.bpm,
)