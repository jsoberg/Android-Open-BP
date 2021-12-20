package com.soberg.openbp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soberg.openbp.domain.reading.BpReading
import com.soberg.openbp.domain.reading.mmHg
import com.soberg.openbp.ui.BpReadingListViewModel.State.Complete
import com.soberg.openbp.ui.BpReadingListViewModel.State.Loading
import com.soberg.openbp.ui.theme.OpenBpTheme

@Composable
fun BpReadingListScreen(
    viewModel: BpReadingListViewModel,
) {
    val state by viewModel.state.collectAsState()
    BpReadingListScreen(state)
}

@Composable
internal fun BpReadingListScreen(
    state: BpReadingListViewModel.State,
) {
    when (state) {
        is Loading -> LoadingContent()
        is Complete -> BpReadingListContent(readings = state.readings)
        // TODO Handle errors.
    }
}

@Composable
private fun LoadingContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun BpReadingListContent(
    readings: List<BpReading>,
) {
    // TODO: Handle empty readings list.
    LazyColumn {
        items(readings) { reading ->
            BpReadingCard(reading)
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun BpReadingsListScreenPreview() {
    OpenBpTheme {
        BpReadingListScreen(
            state = Complete(
                listOf(
                    BpReading(systolic = 120.mmHg, diastolic = 70.mmHg),
                    BpReading(systolic = 115.mmHg, diastolic = 65.mmHg),
                    BpReading(systolic = 110.mmHg, diastolic = 60.mmHg),
                )
            )
        )
    }
}
