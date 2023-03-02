package com.example.fetchapprenticeshiptest.di

import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Singleton
    @Provides
    fun ProvidesKtorClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                gson()
            }
        }
    }

    @Singleton
    @Provides
    fun ProvidesItemsNetworkDataSource(ktorClient: HttpClient): ItemsDataSource {
        return ItemsDataSource(ktorClient)
    }
}