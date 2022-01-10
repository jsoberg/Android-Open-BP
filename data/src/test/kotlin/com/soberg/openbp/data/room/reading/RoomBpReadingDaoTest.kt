package com.soberg.openbp.data.room.reading

import androidx.room.Room
import com.soberg.openbp.data.room.OpenBpRoomDatabase
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.random.Random

@RunWith(RobolectricTestRunner::class)
class RoomBpReadingDaoTest {

    private lateinit var database: OpenBpRoomDatabase
    private lateinit var dao: RoomBpReadingDao

    @Before
    fun setup() {
        val context = RuntimeEnvironment.getApplication()
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
    fun `returns inserted reading for loadById`() {
        runBlocking {
            val firstReading = createNewReading()
            val id = dao.upsert(firstReading)
            val loaded = dao.loadById(id)
            val expected = firstReading.copy(id = id)
            assertThat(loaded).isEqualTo(expected)
        }
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