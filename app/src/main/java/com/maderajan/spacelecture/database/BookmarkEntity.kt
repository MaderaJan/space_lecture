package com.maderajan.spacelecture.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val summary: String,
    val url: String,
    val newsSite: String,
    val imageUrl: String?,
    val publishedAt: String,
)