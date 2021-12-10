package com.soberg.openbp.readings.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soberg.openbp.databinding.BpReadingListItemBinding
import com.soberg.openbp.domain.reading.BpReading
import com.soberg.openbp.readings.view.BpReadingListAdapter.ViewHolder

class BpReadingListAdapter() : ListAdapter<BpReading, ViewHolder>(BpReadingDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BpReadingListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: ViewHolder) {
        holder.onRecycled()
    }

    class ViewHolder(
        private val binding: BpReadingListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(reading: BpReading) {
            binding.bpReadingValue.text = "${reading.systolic}/${reading.diastolic}"
        }

        fun onRecycled() {
            // TODO reset click listener.
        }
    }
}