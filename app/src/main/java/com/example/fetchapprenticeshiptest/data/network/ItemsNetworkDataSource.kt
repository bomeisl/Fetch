package com.example.fetchapprenticeshiptest.data.network

import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
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



class ItemsDataSource @Inject constructor(private val ktorClient: HttpClient) {

    suspend fun getItemsList(): List<Item_Network> {
        val response: List<Item_Network> = ktorClient.get("https://fetch-hiring.s3.amazonaws.com/hiring.json").body()
        return response
            .filter { !it.id.isNullOrBlank() }
            .filter { !it.listId.isNullOrBlank() }
            .filter { !it.name.isNullOrBlank() }
    }

}