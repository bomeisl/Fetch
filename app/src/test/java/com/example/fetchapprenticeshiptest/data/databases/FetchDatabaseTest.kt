package com.example.fetchapprenticeshiptest.data.databases

import android.content.ClipData.Item
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest= Config.NONE)
@RunWith(RobolectricTestRunner::class)
class FetchDatabaseTest {
    private lateinit var itemDao: ItemDao
    private lateinit var db: FetchDatabase
    val scope = TestScope()

    @Before
    fun createDb() {
        Dispatchers.setMain(StandardTestDispatcher(scope.testScheduler))
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, FetchDatabase::class.java).build()
        itemDao = db.itemDao()

    }

    @After
    fun resetCoroutines() {
        Dispatchers.resetMain()
    }
    fun closeDb() {
        db.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testWriteAndRead() {
        val item: Item_DB = Item_DB(id = 999, listID = 999, name = "Item 9999")
        val job = scope.runTest {
            withContext(Dispatchers.IO) {
                itemDao.upsertItem(item)
                assert(itemDao.pullItems().contains(item))
            }
        }
    }

    @Test
    fun orderingTest() {
        val item1: Item_DB = Item_DB(id = 12, listID = 1, name = "Item 12")
        val item2: Item_DB = Item_DB(id = 13, listID = 2, name = "Item 13")
        val item3: Item_DB = Item_DB(id = 1, listID = 4, name = "Item 1")
        val itemList: List<Item_DB> = listOf(item3, item2, item1)
        val orderJob = scope.runTest {
            withContext(Dispatchers.IO) {
                itemList.forEach{
                    itemDao.upsertItem(it)
                }
                assert(itemDao.pullItems() == listOf<Item_DB>(item1, item2, item3))
            }
        }
    }



}