package com.maderajan.spacelecture.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.maderajan.spacelecture.R
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.databinding.ItemSpaceListBinding

// TODO 5. SpaceListViewHolder
class SpaceListViewHolder(
    private val binding: ItemSpaceListBinding
) : RecyclerView.ViewHolder(binding.root) {

    // TODO 6- (S) Bind data to ViewHolder
    fun bind(item: SpaceNews, onItemClicked: (SpaceNews) -> Unit, onBookMarkClicked: (SpaceNews) -> Unit) {
        // TODO 6- (S) Setup click listener and return item
        // TODO 6- (S) Hint: onItemClicked(item)
        // binding.root

        // Loading Image from URL
        binding.imageView.load(item.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_image_placeholder)
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(16f))
        }

        // TODO 6- (S) Bind text to TextViews
//        binding.titleTextView.text =
//        binding.newsSiteTextView.text =
//        binding.dateTextView.text =

        // TODO 6- (S) Setup click listener and return item
        // TODO 6- (S) Hint: onBookMarkClicked(item)
//        binding.bookMarkImageView

        // TODO 6- (S) Setup icon depend on item.isBookmarked
        // TODO 6- (S) Use –> R.drawable.ic_bookmark_filled, R.drawable.ic_bookmark
        // TODO 6- (S) Hint: setImageResource
//        binding.bookMarkImageView
    }
}