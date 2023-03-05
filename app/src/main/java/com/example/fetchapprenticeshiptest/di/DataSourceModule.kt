package com.example.fetchapprenticeshiptest.di

import com.example.fetchapprenticeshiptest.data.network.ItemsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Singleton
    @Provides
    fun ProvidesHttpEngine(): HttpClientEngine {
        return CIO.create()
    }

    @Singleton
    @Provides
    fun ProvidesItemsNetworkDataSource(engine: HttpClientEngine): ItemsDataSource {
        return ItemsDataSource(engine = engine)
    }
}