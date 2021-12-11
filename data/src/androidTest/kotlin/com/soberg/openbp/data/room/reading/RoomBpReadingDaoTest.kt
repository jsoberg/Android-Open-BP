package com.soberg.openbp.data.room.reading

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.soberg.openbp.data.room.OpenBpRoomDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

// TODO Remove annotation when runBlockingTest is no longer marked as experimental.
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RoomBpReadingDaoTest {

    private lateinit var database: OpenBpRoomDatabase
    private lateinit var dao: RoomBpReadingDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room
            .inMemoryDatabaseBuilder(context, OpenBpRoomDatabase::class.java)
            .build()
        dao = database.bpReadingDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun loadByIdReturnsExpectedBpReading() = runBlockingTest {
        val firstReading = createNewReading()
        val id = dao.upsert(firstReading)
        val loaded = dao.loadById(id)
        val expected = firstReading.copy(id = id)
        assertThat(loaded).isEqualTo(expected)
    }

    private fun createNewReading() = RoomBpReading(
        systolic = randomShort(),
        diastolic = randomShort(),
        recordedTime = Random.nextLong(),
        pulse = randomShort()
    )

    private fun randomShort() =
        Random.nextInt(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
}