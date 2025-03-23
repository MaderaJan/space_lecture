package com.maderajan.spacelecture.api.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO 3. Responses
@Serializable
data class SpaceFlightNewsResponseWrapper(
    val results: List<SpaceFlightNewsResponse>
)

@Serializable
data class SpaceFlightNewsResponse(
    val id: Long,
    val title: String,
    val url: String,
    val summary: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("news_site")
    val newsSite: String,
    @SerialName("published_at")
    val publishedAt: String,
)

@Serializable
data class SpaceFlightNewsInfoWrapper(
    @SerialName("news_sites")
    val newsSites: List<String>
)