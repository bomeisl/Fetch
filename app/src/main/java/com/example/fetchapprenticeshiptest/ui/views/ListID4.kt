package com.example.fetchapprenticeshiptest.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ListID4Screen(item4List: StateFlow<List<Item_DB>>) {

    val itemList: State<List<Item_DB>> = item4List.collectAsState()

    Text(text = itemList.value.toString())
}