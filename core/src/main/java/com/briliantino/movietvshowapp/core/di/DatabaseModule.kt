package com.briliantino.movietvshowapp.core.di

import android.content.Context
import androidx.room.Room
import com.briliantino.movietvshowapp.core.data.local.room.AppDao
import com.briliantino.movietvshowapp.core.data.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    private val passphrase: ByteArray = SQLiteDatabase.getBytes("briliantino".toCharArray())
    val factory = SupportFactory(passphrase)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "AppsMtv.db"
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .openHelperFactory(factory)
        .build()

    @Provides
    fun provideTourismDao(database: AppDatabase): AppDao = database.appDao()
}