package com.soberg.openbp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomBpReading::class], version = 1)
abstract class OpenBpRoomDatabase : RoomDatabase() {
    abstract fun bpReadingDao(): RoomBpReadingDao
}
