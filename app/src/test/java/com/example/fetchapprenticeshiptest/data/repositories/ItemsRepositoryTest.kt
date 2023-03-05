package com.example.fetchapprenticeshiptest.data.repositories

import com.example.fetchapprenticeshiptest.data.databases.ItemDao
import com.example.fetchapprenticeshiptest.data.network.Item_Network
import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import dagger.hilt.android.qualifiers.ActivityContext
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

//The network GET call and JSON deserialization were already Unit tested in the
//ItemsDataSourceTest and the Upsert Items Dao transaction was already Unit
//tested in the FetchDatabaseTest, so all that is left to test at the Repository
//level is the null filter function, the network response will be mocked and
//the database transaction will be omitted
@ExperimentalCoroutinesApi
@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner::class)
class ItemsRepositoryTest {

    private val scope = TestScope()

    @MockK
    lateinit var itemDao: ItemDao

    @MockK
    lateinit var itemsDataSource: ItemsDataSource

    @Before
    fun createDispaters() {
        Dispatchers.setMain(StandardTestDispatcher(scope.testScheduler))
    }

    @After
    fun resetCoroutines() {
        Dispatchers.resetMain()
    }

    @Test
    fun databaseRefreshTest() {
        val itemDao1 = mockk<ItemDao>()
        val itemsDataSource1 = mockk<ItemsDataSource>()

        val mockedNetworkResponse =
            listOf<Item_Network>(
                Item_Network("1","2","Item 1"),
                Item_Network("null", "null", ""),
                Item_Network("9", "", "null")
            )

        coEvery { itemsDataSource1.getItemsList() } returns mockedNetworkResponse

        val itemRepo: ItemsRepository = ItemsRepository(
            itemDao = itemDao1, itemsDataSource = itemsDataSource1
        )

        val job = scope.runTest {
            withContext(Dispatchers.IO) {
                val filteredList = itemRepo.nullFilter(itemsDataSource1.getItemsList())
                assert(filteredList == listOf<Item_Network>( Item_Network("1","2","Item 1")))
            }
        }
    }

}