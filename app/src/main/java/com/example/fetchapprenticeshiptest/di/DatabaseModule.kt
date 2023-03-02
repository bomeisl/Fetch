package com.example.fetchapprenticeshiptest.di

import android.content.Context
import androidx.room.Room
import com.example.fetchapprenticeshiptest.data.databases.FetchDatabase
import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun providesItemDao(database: FetchDatabase): ItemDao {
        return database.itemDao()
    }

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context) : FetchDatabase {
        return Room.databaseBuilder(
            appContext,
            FetchDatabase::class.java,
            "fetch.db"
        ).build()
    }
}