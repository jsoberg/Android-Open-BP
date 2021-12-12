package com.soberg.openbp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soberg.openbp.domain.reading.BpReading
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

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            // TODO: Handle errors
            loadBpReadingsUseCase.loadBpReadings()
                .collect { readings ->
                    _state.value = State.Complete(readings)
                }
        }
    }

    sealed interface State {
        object Loading : State

        object Error : State

        data class Complete(
            val readings: List<BpReading>
        ) : State
    }
}