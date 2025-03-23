package com.maderajan.spacelecture.repository

import com.maderajan.spacelecture.api.data.SpaceFlightNewsResponse
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.database.BookmarkEntity

// TODO 8. Mappers
fun SpaceFlightNewsResponse.toSpaceNews() = SpaceNews(
    id = this.id,
    title = this.title,
    summary = this.summary,
    url = this.url,
    newsSite = this.newsSite,
    imageUrl = this.imageUrl,
    publishedAt = this.publishedAt,
    isBookmarked = false // TODO
)

fun SpaceNews.toEntity() = BookmarkEntity(
    id = this.id,
    title = this.title,
    summary = this.summary,
    url = this.url,
    newsSite = this.newsSite,
    imageUrl = this.imageUrl,
    publishedAt = this.publishedAt,
)

fun BookmarkEntity.toSpaceNews() = SpaceNews(
    id = this.id,
    title = this.title,
    summary = this.summary,
    url = this.url,
    newsSite = this.newsSite,
    imageUrl = this.imageUrl,
    publishedAt = this.publishedAt,
    isBookmarked = true
)