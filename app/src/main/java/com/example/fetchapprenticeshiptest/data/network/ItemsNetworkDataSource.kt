package com.example.fetchapprenticeshiptest.data.network

import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import dagger.hilt.android.qualifiers.ActivityContext
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import javax.inject.Inject


data class Item_Network(
    val id: String,
    val listId: String,
    val name: String
)



fun Item_Network.toDB(): Item_DB =
    Item_DB(
    id = id.toInt(),
    listID = listId.toInt(),
    name = name
    )


//In case any of the Json fields are null or blank, we'll filter them out at
//the network call level
class ItemsDataSource @Inject constructor(private val engine: HttpClientEngine) {
    val itemsClient: HttpClient =
        HttpClient(engine) {
            install(ContentNegotiation) {
                gson()
            }
        }

    suspend fun getItemsList(): List<Item_Network> {
        return itemsClient.get("https://fetch-hiring.s3.amazonaws.com/hiring.json").body()
    }

}