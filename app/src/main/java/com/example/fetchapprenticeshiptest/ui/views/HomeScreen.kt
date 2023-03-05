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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.ui.theme.Forest5
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    listofItems: StateFlow<List<Item_DB>>,
    modifier: Modifier = Modifier.testTag("home_screen")
) {

    val itemList: State<List<Item_DB>> = listofItems.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("lazy_column"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item{Spacer(modifier = Modifier.height(100.dp))}

        items(itemList.value) { item ->
            ItemCard(item = item)
        }
        item { Spacer(modifier = Modifier.height(100.dp)) }
            
    }

}

@Composable
fun ItemCard(item: Item_DB) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .testTag("card"),
        colors = CardDefaults.cardColors(
            containerColor = Forest5
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(text = "Item Name: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = item.name, fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
            Row() {
                Text(text = "Item ID: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = item.id.toString(), fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
            Row() {
                Text(text = "Item's List ID: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = item.listID.toString(), fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }

        }
    }
}