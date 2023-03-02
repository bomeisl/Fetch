package com.example.fetchapprenticeshiptest.di

import com.example.fetchapprenticeshiptest.data.databases.FetchDatabase
import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import com.example.fetchapprenticeshiptest.data.repositories.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun ProvidesItemsRepository(itemDao: ItemDao, itemsDataSource: ItemsDataSource): ItemsRepository {
        return ItemsRepository(itemDao, itemsDataSource)
    }


}