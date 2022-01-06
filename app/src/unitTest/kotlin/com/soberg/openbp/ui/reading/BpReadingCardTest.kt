package com.soberg.openbp.ui.reading

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.soberg.openbp.domain.classification.Classification
import com.soberg.openbp.domain.reading.mmHg
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(instrumentedPackages = ["androidx.loader.content"])
@RunWith(RobolectricTestRunner::class)
class BpReadingCardTest {

    private val viewItem = BpReadingViewItem(
        id = 1,
        systolic = 120.mmHg,
        diastolic = 70.mmHg,
        classification = Classification.NORMAL
    )

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            BpReadingCard(reading = viewItem)
        }
    }

    // TODO: remove this test
    @Test
    fun `test method for kover`() {
        composeTestRule.onNodeWithText("120/70")
            .assertExists()
    }
}