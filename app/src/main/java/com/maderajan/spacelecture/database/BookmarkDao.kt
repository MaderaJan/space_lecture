package com.maderajan.spacelecture.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// TODO 7. Entity
@Dao
interface BookmarkDao {

    @Query("SELECT * FROM BookmarkEntity")
    fun selectAllAsFlow(): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persist(entity: BookmarkEntity)

    // TODO (S) 13.
    suspend fun deleteById(id: Long)
}