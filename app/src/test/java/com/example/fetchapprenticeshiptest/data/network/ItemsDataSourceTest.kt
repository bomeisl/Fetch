package com.example.fetchapprenticeshiptest.data.network

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ItemsDataSourceTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    val scope = TestScope()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun createKtorClient() {
        Dispatchers.setMain(StandardTestDispatcher(scope.testScheduler))

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testKtorClient() {
        runBlocking {
            val mockEngine = MockEngine { request ->
                respond(
                    content = ByteReadChannel("""[{"id": 755, "listId": 2, "name": ""},
                        {"id": 203, "listId": 2, "name": ""},
                        {"id": 684, "listId": 1, "name": "Item 684"},
                        {"id": 276, "listId": 1, "name": "Item 276"},
                        {"id": 736, "listId": 3, "name": null},
                        {"id": 926, "listId": 4, "name": null},
                        {"id": 808, "listId": 4, "name": "Item 808"},
                        {"id": 599, "listId": 1, "name": null},
                        {"id": 424, "listId": 2, "name": null},
                        {"id": 444, "listId": 1, "name": ""},
                        {"id": 809, "listId": 3, "name": null},
                        {"id": 293, "listId": 2, "name": null}]"""),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }

            val itemsNetworkDataSource = ItemsDataSource(mockEngine)

            Assert.assertEquals("Item 684", itemsNetworkDataSource.getItemsList()[2].name)
            Assert.assertEquals("599", itemsNetworkDataSource.getItemsList()[7].id)

        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun resetCoroutines() {
        Dispatchers.resetMain()
    }

}


