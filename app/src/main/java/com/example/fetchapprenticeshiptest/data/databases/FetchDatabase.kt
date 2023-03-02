package com.example.fetchapprenticeshiptest.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Singleton
@Database(entities = [Item_DB::class], version = 1)
abstract class FetchDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

}