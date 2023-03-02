package com.example.fetchapprenticeshiptest.data.repositories

import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import com.example.fetchapprenticeshiptest.data.network.Item_Network
import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import com.example.fetchapprenticeshiptest.data.network.toDB
import javax.inject.Inject

class ItemsRepository @Inject constructor(val itemDao: ItemDao, val itemsDataSource: ItemsDataSource) {

    suspend fun refreshDatabase() {
        val newItemList = itemsDataSource.getDailyQuoteList()
        newItemList.forEach { item->
            itemDao.upsertItem(item.toDB())
        }
    }

    suspend fun returnNetworkResults() = itemsDataSource.getDailyQuoteList()

}