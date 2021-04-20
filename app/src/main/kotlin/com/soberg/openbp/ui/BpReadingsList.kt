package com.soberg.openbp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.soberg.openbp.data.BpReading
import com.soberg.openbp.viewmodel.BpReadingsListViewModel

@Preview
@Composable
fun BpReadingsListScreen(
    viewModel: BpReadingsListViewModel = BpReadingsListViewModel()
) {
    Surface(color = MaterialTheme.colors.background) {
        BpReadingsList(
            modifier = Modifier.fillMaxSize(),
            readings = viewModel.getState().readings,
        )
    }
}

@Composable
fun BpReadingsList(
    modifier: Modifier = Modifier,
    readings: List<BpReading>
) {
    LazyColumn(modifier = modifier) {
        items(readings) { reading ->
            BpReadingListItem(reading)
        }
    }
}