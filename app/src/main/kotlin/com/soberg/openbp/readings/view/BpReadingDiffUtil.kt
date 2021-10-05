package com.soberg.openbp.readings.view

import androidx.recyclerview.widget.DiffUtil
import com.soberg.openbp.data.BpReading

class BpReadingDiffUtil : DiffUtil.ItemCallback<BpReading>() {

    override fun areItemsTheSame(oldItem: BpReading, newItem: BpReading) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: BpReading, newItem: BpReading) =
        oldItem == newItem
}