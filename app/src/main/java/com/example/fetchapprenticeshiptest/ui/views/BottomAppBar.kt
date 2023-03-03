package com.example.fetchapprenticeshiptest.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fetchapprenticeshiptest.ui.theme.Purple40

@Composable
fun FetchBottomAppBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier,
        containerColor = Purple40,
        contentColor = Color.White,
        tonalElevation = 10.dp,
        content = {
                    Row() {
                        TextButton(onClick = { navController.navigate(Routes.HOME.name) }) {
                            Column() {
                                Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = Color.White)
                                Text(text = "Home", color = Color.White)
                            }
                        }
                        TextButton(onClick = { navController.navigate(Routes.PAGE1.name) }) {
                            Text(text = "List 1", color = Color.White)

                        }
                        TextButton(onClick = { navController.navigate(Routes.PAGE2.name) }) {
                            Text(text = "List 2", color = Color.White)

                        }
                        TextButton(onClick = { navController.navigate(Routes.PAGE3.name) }) {
                            Text(text = "List 3", color = Color.White)
                        }
                        TextButton(onClick = { navController.navigate(Routes.PAGE4.name) }) {
                            Text(text = "List 4", color = Color.White)
                        }
                    }
                }

    )
}