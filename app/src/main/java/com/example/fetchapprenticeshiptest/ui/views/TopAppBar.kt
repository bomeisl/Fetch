package com.example.fetchapprenticeshiptest.ui.views

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchapprenticeshiptest.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchTopAppBar(onSearch: (String) -> Unit) {
    var searchText = remember { mutableStateOf("") }
    Column() {
        TopAppBar(
            title = { Text(text = "Fetch Rewards Item Fetcher", color = Color.White, fontSize = 27.sp) },
            modifier = Modifier
                .padding(2.dp),
            navigationIcon = { androidx.compose.material3.Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White) },
            windowInsets = WindowInsets(left = 3.dp, right = 3.dp),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Purple40)
        )
        TextField(
            value = searchText.value,
            onValueChange = {searchText.value = it
                            onSearch(searchText.value)
                            },
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ },
                    content = {
                        Icon(Icons.Default.Search,
                            "",
                            tint = Color.Black)
                              }
                )
            }
        )


    }

}