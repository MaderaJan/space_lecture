package com.maderajan.spacelecture.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.maderajan.spacelecture.R
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.databinding.ItemSpaceListBinding

class SpaceListViewHolder(
    private val binding: ItemSpaceListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SpaceNews, onItemClicked: (SpaceNews) -> Unit, onBookMarkClicked: (SpaceNews) -> Unit) {
        binding.root.setOnClickListener {
            onItemClicked(item)
        }

        // Loading Image from URL
        binding.imageView.load(item.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_image_placeholder)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(16f))
        }

        binding.titleTextView.text = item.title
        binding.newsSiteTextView.text = item.newsSite
        binding.dateTextView.text = item.publishedAt

        binding.bookMarkImageView.setOnClickListener {
            onBookMarkClicked(item)
        }

        binding.bookMarkImageView.setImageResource(
            if (item.isBookmarked) {
                R.drawable.ic_bookmark_filled
            } else {
                R.drawable.ic_bookmark
            }
        )
    }
}