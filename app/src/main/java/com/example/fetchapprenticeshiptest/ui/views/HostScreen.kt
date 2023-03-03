package com.example.fetchapprenticeshiptest.ui.views

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fetchapprenticeshiptest.ui.viewmodels.HomeViewModel

enum class Routes {
    HOME, PAGE1, PAGE2, PAGE3, PAGE4
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HostScreen(homeViewModel: HomeViewModel = viewModel()) {
    val navController: NavHostController = rememberNavController()
    val onSearch: (String) -> Unit =
        {homeViewModel.searchText.value = it
            homeViewModel.refreshViewModel()

        }
    Scaffold(
        topBar = { FetchTopAppBar(onSearch) },
        content = {
                  NavHost(
                      navController = navController,
                      startDestination = Routes.HOME.name) {
                          composable(Routes.HOME.name) {

                              HomeScreen(homeViewModel.itemList)
                          }

                          composable(Routes.PAGE1.name) {

                              HomeScreen1(item1List = homeViewModel.item1List)
                          }

                          composable(Routes.PAGE2.name) {

                              HomeScreen2(item2List = homeViewModel.item2List)
                          }

                          composable(Routes.PAGE3.name) {

                              HomeScreen3(item3List = homeViewModel.item3List)
                          }

                          composable(Routes.PAGE4.name) {

                              HomeScreen4(item4List = homeViewModel.item4List)
                          }
                      }
                  },

        bottomBar = { FetchBottomAppBar(navController = navController)}
    )

}