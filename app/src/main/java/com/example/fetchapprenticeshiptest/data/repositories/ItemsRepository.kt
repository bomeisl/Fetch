package com.example.fetchapprenticeshiptest.data.repositories

import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import com.example.fetchapprenticeshiptest.data.network.Item_Network
import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import com.example.fetchapprenticeshiptest.data.network.toDB
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val itemDao: ItemDao, private val itemsDataSource: ItemsDataSource) {

    suspend fun refreshDatabase() {
        val newItemList = itemsDataSource.getItemsList()
        val finalList = newItemList
        finalList.forEach { item-> itemDao.upsertItem(item.toDB()) }
    }

    suspend fun returnNetworkResults() = itemsDataSource.getItemsList()

    suspend fun returnDBResults() = itemDao.pullItems()
}