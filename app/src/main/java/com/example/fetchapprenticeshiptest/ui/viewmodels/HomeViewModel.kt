package com.example.fetchapprenticeshiptest.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.data.repositories.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val itemsRepository: ItemsRepository): ViewModel() {
    var searchText: MutableStateFlow<String> = MutableStateFlow("")
    var itemList: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item1List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item2List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item3List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())
    var item4List: MutableStateFlow<List<Item_DB>> = MutableStateFlow(listOf())

    //attempt to refresh the database with new results from a new GET request
    //to the network. If there is no internet connection, or some network
    //error occurs, we simply display the last cached successful network
    //GET request already stored in the database
    fun refreshViewModel() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                itemsRepository.refreshDatabase()
                val results = itemsRepository.returnDBResults()
                itemList.value = results
                    .filter { it.id.toString().contains(searchText.value) }
                item1List.value = results
                    .filter { it.listID == 1 }
                    .filter { it.id.toString().contains(searchText.value) }
                item2List.value = results
                    .filter { it.listID == 2 }
                    .filter { it.id.toString().contains(searchText.value) }
                item3List.value = results
                    .filter { it.listID == 3 }
                    .filter { it.id.toString().contains(searchText.value) }
                item4List.value = results
                    .filter { it.listID == 4 }
                    .filter { it.id.toString().contains(searchText.value) }
            } catch (e: Exception) {
                val results = itemsRepository.returnDBResults()
                itemList.value = results
                item1List.value = results
                    .filter { it.listID == 1 }
                    .filter { it.id.toString().contains(searchText.value) }
                item2List.value = results
                    .filter { it.listID == 2 }
                    .filter { it.id.toString().contains(searchText.value) }
                item3List.value = results
                    .filter { it.listID == 3 }
                    .filter { it.id.toString().contains(searchText.value) }
                item4List.value = results
                    .filter { it.listID == 4 }
                    .filter { it.id.toString().contains(searchText.value) }
            }
        }
    }

    init {
        refreshViewModel()
    }

}