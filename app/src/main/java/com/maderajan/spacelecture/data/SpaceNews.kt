package com.maderajan.spacelecture.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpaceNews(
    val id: Long,
    val title: String,
    val summary: String,
    val url: String,
    val newsSite: String,
    val imageUrl: String?,
    val publishedAt: String,
    val isBookmarked: Boolean,
): Parcelable