package com.maderajan.spacelecture.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM BookmarkEntity")
    fun selectAllAsFlow(): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persist(entity: BookmarkEntity)

    @Query("DELETE FROM BookmarkEntity WHERE id = :id")
    suspend fun deleteById(id: Long)
}