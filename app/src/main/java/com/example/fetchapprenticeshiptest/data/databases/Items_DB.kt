package com.example.fetchapprenticeshiptest.data.databases

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "Items")
data class Item_DB(
    @PrimaryKey @ColumnInfo("id") val id: Int,
    @ColumnInfo("listID") val listID: Int,
    @ColumnInfo("name") val name: String
)

@Dao
interface ItemDao {

    @Query("SELECT * FROM Items WHERE :listID = listID ORDER BY id")
    fun pullItembyListID(listID: Int): Flow<List<Item_DB>>

    @Upsert
    suspend fun upsertItem(item: Item_DB)

    @Delete
    suspend fun deleteItem(item: Item_DB)



}