package com.soberg.openbp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soberg.openbp.data.BpReading

@Preview
@Composable
fun BpReadingListItem(
    reading: BpReading = BpReading(120, 70, 0L)
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