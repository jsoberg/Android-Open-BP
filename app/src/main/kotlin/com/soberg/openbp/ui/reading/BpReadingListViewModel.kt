package com.soberg.openbp.ui.reading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soberg.openbp.domain.classification.AhaClassifier
import com.soberg.openbp.domain.reading.LoadBpReadingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BpReadingListViewModel @Inject constructor(
    private val loadBpReadingsUseCase: LoadBpReadingsUseCase
) : ViewModel() {

    // TODO: Load classifier and create this accordingly
    private val viewItemMapper = BpReadingViewItemMapper(AhaClassifier())

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            // TODO: Handle errors
            loadBpReadingsUseCase.loadBpReadings()
                .collect { readings ->
                    val viewItems = viewItemMapper.map(readings)
                    _state.value = State.Complete(viewItems)
                }
        }
    }

    sealed interface State {
        object Loading : State

        object Error : State

        data class Complete(
            val readings: List<BpReadingViewItem>
        ) : State
    }
}