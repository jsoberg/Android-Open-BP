package com.soberg.openbp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soberg.openbp.data.BpReading
import com.soberg.openbp.data.mmHg

@Preview
@Composable
fun BpReadingListItem(
    reading: BpReading = BpReading(
        systolic = 110.mmHg,
        diastolic = 60.mmHg,
        recordedTime = 0
    )
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Row {
            Text(
                text = "${reading.systolic}/${reading.diastolic}",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(64.dp)
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            )
        }
    }
}