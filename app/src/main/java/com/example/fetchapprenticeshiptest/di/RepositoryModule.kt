package com.example.fetchapprenticeshiptest.di

import android.content.Context
import com.example.fetchapprenticeshiptest.data.databases.FetchDatabase
import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import com.example.fetchapprenticeshiptest.data.repositories.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    fun ProvidesItemsRepository(
                                itemDao: ItemDao, itemsDataSource: ItemsDataSource): ItemsRepository {
        return ItemsRepository(itemDao, itemsDataSource)
    }


}