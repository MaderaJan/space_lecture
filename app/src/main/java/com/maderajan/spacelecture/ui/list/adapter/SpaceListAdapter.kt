package com.maderajan.spacelecture.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.databinding.ItemSpaceListBinding

class SpaceListAdapter(
    private val onItemClicked: (SpaceNews) -> Unit,
    private val onBookMarkClicked: (SpaceNews) -> Unit
) : ListAdapter<SpaceNews, SpaceListViewHolder>(Differ()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceListViewHolder =
        SpaceListViewHolder(ItemSpaceListBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: SpaceListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onItemClicked, onBookMarkClicked)
    }

    internal class Differ : DiffUtil.ItemCallback<SpaceNews>() {
        override fun areItemsTheSame(oldItem: SpaceNews, newItem: SpaceNews): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: SpaceNews, newItem: SpaceNews): Boolean =
            oldItem == newItem
    }
}