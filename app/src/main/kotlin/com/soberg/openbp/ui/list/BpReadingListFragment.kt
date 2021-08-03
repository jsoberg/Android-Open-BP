package com.soberg.openbp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.soberg.openbp.R
import com.soberg.openbp.databinding.BpReadingListFragmentBinding
import com.soberg.openbp.viewmodel.BpReadingsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BpReadingListFragment : Fragment(R.layout.bp_reading_list_fragment) {

    private lateinit var viewBinding: BpReadingListFragmentBinding
    private lateinit var adapter: BpReadingListAdapter

    private val viewModel by viewModels<BpReadingsListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = BpReadingListFragmentBinding.inflate(inflater, container, false)

        adapter = BpReadingListAdapter()
        viewBinding.bpReadingList.adapter = adapter

        // TODO Reactively listen to state changes.
        onStateChange(BpReadingsListViewModel.State(false, emptyList()))
        return viewBinding.root
    }

    private fun onStateChange(state: BpReadingsListViewModel.State) {
        val showProgress = state.isLoading
        viewBinding.loadingProgress.visibility = if (showProgress) View.VISIBLE else View.GONE
        viewBinding.bpReadingList.visibility = if (showProgress) View.GONE else View.VISIBLE
        adapter.submitList(state.readings)
    }
}