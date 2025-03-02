package com.maderajan.spacelecture.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.databinding.ItemSpaceListBinding

// TODO 4. Setup Adapter
class SpaceListAdapter(
    private val onItemClicked: (SpaceNews) -> Unit,
    private val onBookMarkClicked: (SpaceNews) -> Unit
) : ListAdapter<SpaceNews, SpaceListViewHolder>(Differ()) {

    // TODO 4. onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceListViewHolder =
        SpaceListViewHolder(ItemSpaceListBinding.inflate(LayoutInflater.from(parent.context)))

    // TODO 4. onBindViewHolder
    override fun onBindViewHolder(holder: SpaceListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClicked, onBookMarkClicked)
    }

    // TODO 4. DiffUtil
    internal class Differ : DiffUtil.ItemCallback<SpaceNews>() {
        override fun areItemsTheSame(oldItem: SpaceNews, newItem: SpaceNews): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: SpaceNews, newItem: SpaceNews): Boolean =
            oldItem == newItem
    }
}