package com.example.fetchapprenticeshiptest.data.network

import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

data class Item_Network(
    val id: Int,
    val list_id: Int,
    val name: String
)

fun Item_Network.toDB(): Item_DB = Item_DB(
    id = id,
    list_id - list_id,
    name = name
)

class ItemsDataSource @Inject constructor(private val ktorClient: HttpClient) {

    suspend fun getDailyQuoteList(): List<Item_Network> =
        ktorClient.get("https://fetch-hiring.s3.amazonaws.com/hiring.json").body()

}