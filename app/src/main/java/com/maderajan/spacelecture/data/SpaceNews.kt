package com.maderajan.spacelecture.data

// TODO 1. Data
data class SpaceNews(
    val id: Long,
    val title: String,
    val summary: String,
    val url: String,
    val newsSite: String,
    val imageUrl: String?,
    val publishedAt: String,
    val isBookmarked: Boolean,
)