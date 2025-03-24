package com.maderajan.spacelecture.repository

import android.content.Context
import com.maderajan.spacelecture.api.ClientCreator
import com.maderajan.spacelecture.api.SpaceFlightsNewsApi
import com.maderajan.spacelecture.data.SpaceNews
import com.maderajan.spacelecture.database.BookmarkDao
import com.maderajan.spacelecture.database.SpaceDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class SpaceNewsRepository(
    context: Context,
    private val spaceFlightApi: SpaceFlightsNewsApi = ClientCreator.createSpaceApi(),
    private val bookmarkDao: BookmarkDao = SpaceDatabase.create(context).bookmarkDao()
) {

    fun getSpaceFlightsSortedByPublishAt(): Flow<List<SpaceNews>> {
        return combine(
            getBookmarkedSpaceNews(),
            getSpaceFlightsFromApi(),
            { bookmarkedNews, apiNews ->
                connectBookmarkedNewsAndSortByPublishAt(
                    bookmarkedNews, apiNews
                )
            }
        )
    }

    private fun getBookmarkedSpaceNews(): Flow<List<SpaceNews>> {
        return bookmarkDao.selectAllAsFlow()
            .map {
                it.map { entity ->
                    entity.toSpaceNews()
                }
            }
    }

    private fun getSpaceFlightsFromApi(): Flow<List<SpaceNews>> {
        return flow {
            val news = spaceFlightApi.getArticles().results
                .map { response ->
                    response.toSpaceNews()
                }
            emit(news)
        }
    }

    private fun connectBookmarkedNewsAndSortByPublishAt(
        bookmarkedNews: List<SpaceNews>,
        news: List<SpaceNews>
    ): List<SpaceNews> {
        return news.map { newsToMap ->
            newsToMap.copy(isBookmarked = bookmarkedNews.any { it.id == newsToMap.id })
        }.sortedByDescending(SpaceNews::publishedAt)
    }

    suspend fun insertOrDeleteBookMark(news: SpaceNews) {
        if (news.isBookmarked) {
            bookmarkDao.deleteById(news.id)
        } else {
            bookmarkDao.persist(news.toEntity())
        }
    }
}