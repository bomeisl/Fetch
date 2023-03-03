package com.example.fetchapprenticeshiptest.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton

//We'll cache network GET call results here in case
//the user has a flaky (or no) internet connection
//at times for a great offline-first user experience
@Singleton
@Database(entities = [Item_DB::class], version = 1)
abstract class FetchDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

}