package com.soberg.openbp.data.room

import android.content.Context
import androidx.room.Room
import com.soberg.openbp.data.BpReadingRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RoomDatabaseModule {

    companion object {
        @Provides
        internal fun provideBpReadingDao(db: OpenBpRoomDatabase): RoomBpReadingDao =
            db.bpReadingDao()

        @Provides
        @Singleton
        internal fun provideDatabase(@ApplicationContext appContext: Context): OpenBpRoomDatabase =
            Room.databaseBuilder(
                appContext,
                OpenBpRoomDatabase::class.java,
                "open_bp_database"
            ).build()
    }

    @Binds
    internal abstract fun provideRepository(repository: RoomBpReadingRepository): BpReadingRepository
}