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

// TODO 4. Connect api to repository
class SpaceNewsRepository(
    context: Context,
    private val spaceFlightApi: SpaceFlightsNewsApi = ClientCreator.createSpaceApi(),
    private val bookmarkDao: BookmarkDao = SpaceDatabase.create(context).bookmarkDao()
) {

    // TODO 9. Combine outputs to observe news as flow
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

    private fun connectBookmarkedNewsAndSortByPublishAt(bookmarkedNews: List<SpaceNews>, news: List<SpaceNews>): List<SpaceNews> {
        // TODO (S) 11.
        // - Sort by descending using publish at
        // - Combine two inputs bookmarkedNews AND news as one output
        // - The output should represent all news from api but isBookmarked flag show should reflect bookmarked news in database
        return emptyList()
    }

    suspend fun insertOrDeleteBookMark(news: SpaceNews) {
        // TODO (S) 12.
        // - Implement insert or update method
        // - Check the isBookmarked flag for condition
        // - Convert/Map using fun SpaceNews.toEntity() -> Can be found in Mappers.kt
        // - Use bookmarkDao for insert or update
        // - Create SQL in bookmarkDao to delete from database
        // - Use this method in SpaceListFragment an SpaceDetailFragment to delete or update bookmarks (can be find // TODO (S) 14)
    }
}