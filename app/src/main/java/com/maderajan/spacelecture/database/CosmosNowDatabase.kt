package com.maderajan.spacelecture.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// TODO 5. Database
@Database(
    entities = [BookmarkEntity::class],
    version = 1,
    exportSchema = true,
)
abstract class SpaceDatabase : RoomDatabase() {

    companion object {
        private const val NAME = "cosmos-now.db"

        fun create(context: Context): SpaceDatabase =
            Room.databaseBuilder(context, SpaceDatabase::class.java, NAME)
                .build()
    }

    abstract fun bookmarkDao(): BookmarkDao
}