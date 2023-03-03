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
    @PrimaryKey @ColumnInfo("id") var id: Int,
    @ColumnInfo("listID") var listID: Int,
    @ColumnInfo("name") var name: String
)

@Dao
interface ItemDao {

    //Primary sort index is the :listID as per the instructions
    //secondary index is the :id technically, but only with the
    //ends of sorting by :name as per the instructions since the
    //names are all identical except for some having higher or
    //lower numbers matching the corresponding :id
    @Query("SELECT * FROM Items ORDER BY listID ASC, id ASC")
    fun pullItems(): List<Item_DB>

    @Upsert
    suspend fun upsertItem(item: Item_DB)

    @Delete
    suspend fun deleteItem(item: Item_DB)


}