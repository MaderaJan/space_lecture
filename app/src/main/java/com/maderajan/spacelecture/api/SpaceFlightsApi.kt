package com.maderajan.spacelecture.api

import com.maderajan.spacelecture.api.data.SpaceFlightNewsInfoWrapper
import com.maderajan.spacelecture.api.data.SpaceFlightNewsResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

// TODO 1. API Interface
interface SpaceFlightsNewsApi {

    @GET("v4/articles")
    suspend fun getArticles(
        @Query("title_contains") searchText: String? = null,
        @Query("news_site") newsSites: String? = null,
        @Query("published_at_gt") dateFrom: String? = null,
        @Query("published_at_lt") dateTo: String? = null,
        @Query("has_launch") hasLaunch: Boolean? = null,
        @Query("limit") limit: Int = 100
    ): SpaceFlightNewsResponseWrapper

    @GET("v4/info")
    suspend fun getInfo(): SpaceFlightNewsInfoWrapper
}