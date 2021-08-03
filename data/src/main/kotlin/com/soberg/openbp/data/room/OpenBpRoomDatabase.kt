package com.soberg.openbp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomBpReading::class], version = 1)
internal abstract class OpenBpRoomDatabase : RoomDatabase() {
    abstract fun bpReadingDao(): RoomBpReadingDao
}
