package com.example.simplepokedex.presentation.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.simplepokedex.ui.theme.SimplePokedexTheme
import org.junit.Before
import org.junit.Rule

//class HomeScreenTest{
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
//    private lateinit var navController: TestNavHostController
//
//    @Before
//    fun setUp() {
//        composeTestRule.setContent {
//            SimplePokedexTheme {
//                navController = TestNavHostController(LocalContext.current)
//                navController.navigatorProvider.addNavigator(ComposeNavigator())
//                HomeScreen(
//                    navController = navController,
//                    viewModel = HomeViewModel(
//
//                    )
//                )
//            }
//        }
//    }
//}