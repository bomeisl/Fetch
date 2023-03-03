package com.example.fetchapprenticeshiptest.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.ui.theme.Forest4
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen4(item4List: StateFlow<List<Item_DB>>) {

    val itemList: State<List<Item_DB>> = item4List.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item{ Spacer(modifier = Modifier.height(100.dp)) }

        items(itemList.value) { item ->
            ItemCard4(item = item)
        }
        item { Spacer(modifier = Modifier.height(100.dp)) }

    }

}

@Composable
fun ItemCard4(item: Item_DB) {
    Card(
        modifier = Modifier
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Forest4
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(text = "Item Name: ", fontSize = 20.sp)
                Text(text = item.name, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            Row() {
                Text(text = "Item ID: ", fontSize = 20.sp)
                Text(text = item.id.toString(), fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            Row() {
                Text(text = "Item's List ID: ", fontSize = 20.sp)
                Text(text = item.listID.toString(), fontSize = 20.sp, textAlign = TextAlign.Center)
            }

        }
    }
}