package com.example.fetchapprenticeshiptest.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.data.network.Item_Network
import com.example.fetchapprenticeshiptest.data.repositories.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(itemsRepository: ItemsRepository): ViewModel() {

    var itemList: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item1List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item2List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item3List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item4List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    fun refreshViewModel(itemsRepository: ItemsRepository) {
            viewModelScope.launch(Dispatchers.IO) {
                itemsRepository.refreshDatabase()
                val results = itemsRepository.returnDBResults()
                itemList.value = results
                item1List.value = results.filter { it.listID == 1 }
                item2List.value = results.filter { it.listID == 2 }
                item3List.value = results.filter { it.listID == 3 }
                item4List.value = results.filter { it.listID == 4 }

            }
    }

    init {
        refreshViewModel(itemsRepository)
    }



}