package com.briliantino.movietvshowapp.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.briliantino.movietvshowapp.core.data.local.entity.MovieEntity
import com.briliantino.movietvshowapp.core.data.local.entity.TvShowEntity


@Database(entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}