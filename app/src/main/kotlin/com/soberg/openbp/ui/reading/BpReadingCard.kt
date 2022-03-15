package com.soberg.openbp.ui.reading

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soberg.openbp.R
import com.soberg.openbp.domain.classification.Classification
import com.soberg.openbp.domain.reading.Pressure.Companion.mmHg
import com.soberg.openbp.ui.theme.*

@Composable
internal fun BpReadingCard(
    reading: BpReadingViewItem,
) {
    Card(
        // TODO: Store dimensions centrally.
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(
                top = 4.dp,
                start = 2.dp,
                end = 2.dp
            )
    ) {
        BpReadingCardContent(reading)
    }
}

@Composable
private fun BpReadingCardContent(
    reading: BpReadingViewItem,
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        val color = colorForClassification(reading.classification)
        Box(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
                .size(30.dp)
                .clip(CircleShape)
                .background(color)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "${reading.systolic}/${reading.diastolic}",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            style = PressureTextStyle
        )
        Text(
            text = stringResource(id = R.string.pressure_abbreviation),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp),
            style = PressureAbbrTextStyle
        )
    }
}

private fun colorForClassification(classification: Classification): Color =
    when (classification) {
        // TODO Use themed colors
        Classification.NORMAL -> Green500
        Classification.ELEVATED -> Yellow500
        Classification.HYPERTENSION_STAGE_1 -> Orange500
        Classification.HYPERTENSION_STAGE_2 -> DeepOrange500
        Classification.HYPERTENSIVE_CRISIS -> Red500
    }

private val PressureTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp
)

private val PressureAbbrTextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
)

@Preview(name = "Light Mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Large Font", fontScale = 1.5f)
@Composable
private fun BpReadingCardPreview() = OpenBpTheme {
    BpReadingCard(
        BpReadingViewItem(1, 120.mmHg, 70.mmHg, Classification.NORMAL)
    )
}