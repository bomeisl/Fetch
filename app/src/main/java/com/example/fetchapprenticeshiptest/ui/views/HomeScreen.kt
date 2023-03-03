package com.example.fetchapprenticeshiptest.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.data.network.Item_Network
import com.example.fetchapprenticeshiptest.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val listOfItems: State<List<Item_DB>> = homeViewModel.itemList.collectAsState()

    Text(text = listOfItems.value.toString())
}