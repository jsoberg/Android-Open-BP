package com.soberg.openbp.ui.reading

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soberg.openbp.domain.classification.Classification.*
import com.soberg.openbp.domain.reading.Pressure.Companion.mmHg
import com.soberg.openbp.ui.reading.BpReadingListViewModel.State.*
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
    Scaffold(
        floatingActionButton = {
            if (state is Complete) {
                Fab {
                    // TODO Implement click
                }
            }
        }
    ) {
        when (state) {
            is Loading -> LoadingContent()
            is Complete -> BpReadingListContent(readings = state.readings)
            is Error -> TODO("Handle errors")
        }
    }
}

@Composable
private fun Fab(onClick: () -> Unit) {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        onClick = onClick,
        content = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null
            )
        }
    )
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
    readings: List<BpReadingViewItem>,
) {
    // TODO: Handle empty readings list.
    LazyColumn {
        items(readings) { reading ->
            BpReadingCard(reading)
        }
    }
}

@Preview(name = "Light Mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Large Font", fontScale = 1.5f)
@Composable
private fun BpReadingsListScreenPreview() = OpenBpTheme {
    BpReadingListScreen(
        state = Complete(
            listOf(
                BpReadingViewItem(1, 120.mmHg, 70.mmHg, NORMAL),
                BpReadingViewItem(1, 130.mmHg, 70.mmHg, ELEVATED),
                BpReadingViewItem(1, 130.mmHg, 80.mmHg, HYPERTENSION_STAGE_1),
                BpReadingViewItem(1, 140.mmHg, 90.mmHg, HYPERTENSION_STAGE_2),
                BpReadingViewItem(1, 190.mmHg, 120.mmHg, HYPERTENSIVE_CRISIS),
            )
        )
    )
}
