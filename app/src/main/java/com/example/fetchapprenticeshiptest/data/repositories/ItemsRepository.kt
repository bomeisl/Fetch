package com.example.fetchapprenticeshiptest.data.repositories

import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import com.example.fetchapprenticeshiptest.data.network.Item_Network
import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import com.example.fetchapprenticeshiptest.data.network.toDB
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val itemDao: ItemDao, private val itemsDataSource: ItemsDataSource) {

    fun nullFilter(items: List<Item_Network>): List<Item_Network> {
        return items
            .filter { !it.id.isNullOrBlank() }
            .filter { !it.listId.isNullOrBlank() }
            .filter { !it.name.isNullOrBlank() }
    }

    suspend fun returnNetworkResults() = itemsDataSource.getItemsList()

    suspend fun returnDBResults() = itemDao.pullItems()

    suspend fun refreshDatabase() {
        val newItemList = returnNetworkResults()
        val finalList = nullFilter(newItemList)
        finalList.forEach { item-> itemDao.upsertItem(item.toDB()) }
    }



}