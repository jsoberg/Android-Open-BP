package com.soberg.openbp.ui.reading

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soberg.openbp.R
import com.soberg.openbp.domain.classification.Classification
import com.soberg.openbp.domain.reading.mmHg

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
        modifier = Modifier
            .padding(
                start = 8.dp,
                top = 4.dp
            )
            .wrapContentHeight()
    ) {
        Text(
            text = "${reading.systolic}/${reading.diastolic}",
            modifier = Modifier.align(Alignment.Bottom),
            style = PressureTextStyle
        )
        Text(
            text = stringResource(id = R.string.pressure_abbreviation),
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(
                    start = 4.dp,
                    bottom = 5.dp
                ),
            style = PressureAbbrTextStyle
        )
    }
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

@Preview(
    showBackground = true
)
@Composable
private fun BpReadingCardPreview() {
    BpReadingCard(
        BpReadingViewItem(1, 120.mmHg, 70.mmHg, Classification.NORMAL)
    )
}