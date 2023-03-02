package com.example.fetchapprenticeshiptest.di

import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import javax.inject.Singleton

object NetworkModule {

        @Singleton
        @Provides
        fun ProvidesKtorClient(): HttpClient {
            return HttpClient(CIO) {
                install(ContentNegotiation) {
                    gson()
                }
            }
        }

}