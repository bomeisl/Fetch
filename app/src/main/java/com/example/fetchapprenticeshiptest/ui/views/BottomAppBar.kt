package com.example.fetchapprenticeshiptest.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fetchapprenticeshiptest.ui.theme.Purple40

@Composable
fun FetchBottomAppBar(navController: NavController) {
    var selectHome = remember { mutableStateOf(true) }
    var select1 = remember { mutableStateOf(false) }
    var select2 = remember { mutableStateOf(false) }
    var select3 = remember { mutableStateOf(false) }
    var select4 = remember { mutableStateOf(false) }

    BottomAppBar(
        modifier = Modifier,
        containerColor = Purple40,
        contentColor = Color.White,
        tonalElevation = 10.dp,
        content = {
            NavigationRail(
            ) {
                Row() {

                    NavigationRailItem(
                        selected = selectHome.value,
                        onClick = {
                            navController.navigate(Routes.HOME.name)
                            selectHome.value = true
                            select1.value = false
                            select2.value = false
                            select3.value = false
                            select4.value = false
                        },
                        icon = {
                            Column() {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home"
                                )
                                Text(text = "Home")
                            }
                        },
                        colors = NavigationRailItemDefaults
                            .colors(
                                selectedTextColor = Color.Red,
                                unselectedIconColor = Purple40,
                                selectedIconColor = Color.White,
                                indicatorColor = Purple40,
                            )
                    )
                    NavigationRailItem(
                        selected = select1.value,
                        onClick = {
                            select1.value = true
                            selectHome.value = false
                            select2.value = false
                            select3.value = false
                            select4.value = false
                            navController.navigate(Routes.PAGE1.name)
                                  },
                        icon = {
                            Column() {
                                Icon(imageVector = Icons.Default.List, contentDescription = " ")
                                Text(text = "List 1")
                            }

                        },
                        colors = NavigationRailItemDefaults
                            .colors(
                                selectedTextColor = Color.Red,
                                unselectedIconColor = Purple40,
                                selectedIconColor = Color.White,
                                indicatorColor = Purple40,
                            )

                    )
                    NavigationRailItem(
                        selected = select2.value,
                        onClick = {
                            select2.value = true
                            select1.value = false
                            selectHome.value = false
                            select3.value = false
                            select4.value = false
                            navController.navigate(Routes.PAGE2.name)
                                  },
                        icon = {
                            Column() {
                                Icon(imageVector = Icons.Default.List, contentDescription = "")
                                Text(text = "List 2")
                            }
                        },
                        colors = NavigationRailItemDefaults
                            .colors(
                                selectedTextColor = Color.Red,
                                unselectedIconColor = Purple40,
                                selectedIconColor = Color.White,
                                indicatorColor = Purple40,
                            )
                    )
                    NavigationRailItem(
                        selected = select3.value,
                        onClick = {
                            select3.value = true
                            select1.value = false
                            selectHome.value = false
                            select2.value = false
                            select4.value = false
                            navController.navigate(Routes.PAGE3.name) },
                        icon = {
                            Column() {
                                Icon(imageVector = Icons.Default.List, contentDescription = "")
                                Text(text = "List 3")
                            }
                        },
                        colors = NavigationRailItemDefaults
                            .colors(
                                selectedTextColor = Color.Red,
                                unselectedIconColor = Purple40,
                                selectedIconColor = Color.White,
                                indicatorColor = Purple40,
                            )
                    )
                    NavigationRailItem(
                        selected = select4.value,
                        onClick = {
                            select4.value = true
                            select1.value = false
                            selectHome.value = false
                            select3.value = false
                            select2.value = false
                            navController.navigate(Routes.PAGE4.name)
                                  },
                        icon = {
                            Column() {
                                Icon(imageVector = Icons.Default.List, contentDescription = "")
                                Text(text = "List 4")
                            }
                        },
                        colors = NavigationRailItemDefaults
                            .colors(
                                selectedTextColor = Color.Red,
                                unselectedIconColor = Purple40,
                                selectedIconColor = Color.White,
                                indicatorColor = Purple40,
                            )
                    )


                }

            }
        }
    )
}