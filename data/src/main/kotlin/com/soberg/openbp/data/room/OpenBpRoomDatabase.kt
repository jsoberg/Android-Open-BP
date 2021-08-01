package com.soberg.openbp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomBpReading::class], version = 1)
abstract class OpenBpRoomDatabase : RoomDatabase() {
    abstract fun bpReadingDao(): RoomBpReadingDao

    companion object {

        private val DB_LOCK = Any()
        private var INSTANCE: OpenBpRoomDatabase? = null

        fun get(context: Context): OpenBpRoomDatabase =
            synchronized(DB_LOCK) {
                INSTANCE ?: instantiate(context)
            }

        private fun instantiate(context: Context): OpenBpRoomDatabase {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                OpenBpRoomDatabase::class.java,
                "open_bp_database"
            ).build()
            return INSTANCE!!
        }
    }
}
