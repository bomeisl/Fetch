package com.example.fetchapprenticeshiptest.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

enum class Routes {
    HOME, PAGE1, PAGE2, PAGE3, PAGE4
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HostScreen(homeViewModel: HomeViewModel = viewModel()) {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        topBar = { FetchTopAppBar() },
        content = {
                  NavHost(
                      navController = navController,
                      startDestination = Routes.HOME.name) {
                          composable(Routes.HOME.name) {

                              HomeScreen(homeViewModel.itemList)
                          }

                          composable(Routes.PAGE1.name) {

                              ListID1Screen(item1List = homeViewModel.item1List)
                          }

                          composable(Routes.PAGE2.name) {

                              ListID2Screen(item2List = homeViewModel.item2List)
                          }

                          composable(Routes.PAGE3.name) {

                              ListID3Screen(item3List = homeViewModel.item3List)
                          }

                          composable(Routes.PAGE4.name) {

                              ListID4Screen(item4List = homeViewModel.item4List)
                          }
                      }
                  },

        bottomBar = { FetchBottomAppBar(navController = navController)}
    )

}