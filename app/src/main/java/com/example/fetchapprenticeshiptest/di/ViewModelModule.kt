package com.example.fetchapprenticeshiptest.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.fetchapprenticeshiptest.FetchApprenticeshipTestApplication
import com.example.fetchapprenticeshiptest.data.repositories.ItemsRepository
import com.example.fetchapprenticeshiptest.ui.viewmodels.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
object ViewModelModule {

    @Provides
    fun ProvidesHomeViewModel(itemsRepository: ItemsRepository): HomeViewModel {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return HomeViewModel(
                    itemsRepository
                ) as T
            }
        }
        return HomeViewModel(itemsRepository)
    }


}