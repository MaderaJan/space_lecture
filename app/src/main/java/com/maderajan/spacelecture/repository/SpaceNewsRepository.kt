package com.maderajan.spacelecture.repository

import com.maderajan.spacelecture.data.SpaceNews

class SpaceNewsRepository {

    fun getSpaceNews(): List<SpaceNews> {
        val fakeData = mutableListOf<SpaceNews>()

        repeat(100) {
            fakeData.add(
                SpaceNews(
                    id = it.toLong(),
                    title = "Title$it",
                    summary = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    url = "https://picsum.photos/200/300",
                    newsSite = "Space",
                    imageUrl = "https://picsum.photos/200/300",
                    publishedAt = "3.3. 2025",
                    isBookmarked = it % 2 == 0
                )
            )
        }

        return fakeData
    }
}