package com.example.fetchapprenticeshiptest.ui.views

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fetchapprenticeshiptest.data.databases.Item_DB
import com.example.fetchapprenticeshiptest.ui.theme.FetchApprenticeshipTestTheme
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenKtTest {
    val mockedList: List<Item_DB> = listOf(Item_DB(12,1,"Item 12"))
    val mockedList1: List<Item_DB> = listOf(Item_DB(12,1,"Item 12"))
    val mockedList2: List<Item_DB> = listOf(Item_DB(12,2,"Item 12"))
    val mockedList3: List<Item_DB> = listOf(Item_DB(12,3,"Item 12"))
    val mockedList4: List<Item_DB> = listOf(Item_DB(12,4,"Item 12"))


    val mockeditemList: MutableStateFlow<List<Item_DB>> = MutableStateFlow(mockedList)
    val mockeditemList1: MutableStateFlow<List<Item_DB>> = MutableStateFlow(mockedList1)


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun HomeScreenLoadTest() {
        composeTestRule.setContent {
            FetchApprenticeshipTestTheme {
                HomeScreen(listofItems = mockeditemList)
            }
        }
        composeTestRule.onNodeWithTag("card").assertIsDisplayed()
    }

    @Test
    fun List1ScreenLoadTest() {
        composeTestRule.setContent {
            HomeScreen1(item1List = mockeditemList1)
        }
        composeTestRule.onNodeWithTag("card1").assertIsDisplayed()
    }





}