package com.soberg.openbp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.soberg.openbp.data.room.reading.RoomBpReading
import com.soberg.openbp.data.room.reading.RoomBpReadingDao

@Database(entities = [RoomBpReading::class], version = 1)
internal abstract class OpenBpRoomDatabase : RoomDatabase() {
    abstract fun bpReadingDao(): RoomBpReadingDao
}
