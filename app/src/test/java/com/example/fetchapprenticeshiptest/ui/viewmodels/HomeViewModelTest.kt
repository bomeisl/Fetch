package com.example.fetchapprenticeshiptest.ui.viewmodels

import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.data.repositories.ItemsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@Config(manifest= Config.NONE)
@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    private val scope = TestScope()
    val mockedItemsRepository = mockk<ItemsRepository>()

    @Before
    fun createDispaters() {
        Dispatchers.setMain(StandardTestDispatcher(scope.testScheduler))
    }

    @Test
    fun testUnsuccessfulDatabaseRefresh() {
        val testHomeViewModel: HomeViewModel = HomeViewModel(mockedItemsRepository)

        val mockedDatabaseQueryReturn: List<Item_DB> =
            listOf(
                Item_DB(0, 1, "Item 0"),
                Item_DB(12, 3, "Item 12"),
                Item_DB(234, 4, "Item 234")
            )

        coEvery { mockedItemsRepository.refreshDatabase() }.throws(Exception())
        coEvery { mockedItemsRepository.returnDBResults() } returns mockedDatabaseQueryReturn
        val job = scope.runTest {
            withContext(Dispatchers.IO) {

                testHomeViewModel.refreshViewModel()

            }
        }
        assertEquals(mockedDatabaseQueryReturn, testHomeViewModel.itemList.value )
    }

    @Test
    fun testSuccessfulDatabaseRefresh() {
        val testHomeViewModel: HomeViewModel = HomeViewModel(mockedItemsRepository)

        val mockedDatabaseQueryReturn: List<Item_DB> =
            listOf(
                Item_DB(0, 1, "Item 0"),
                Item_DB(12, 3, "Item 12"),
                Item_DB(234, 4, "Item 234")
            )

        coEvery { mockedItemsRepository.refreshDatabase() } returns Unit
        coEvery { mockedItemsRepository.returnDBResults() } returns mockedDatabaseQueryReturn
        val job = scope.runTest {
            withContext(Dispatchers.IO) {

                testHomeViewModel.refreshViewModel()

            }
        }
        assertEquals(mockedDatabaseQueryReturn, testHomeViewModel.itemList.value )
    }

}