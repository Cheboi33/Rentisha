package com.example.rentishaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rentishaapp.models.BottomBarScreen
import com.example.rentishaapp.ui.theme.pages.addlisting.AddListingScreen
import com.example.rentishaapp.ui.theme.pages.home.HomeScreen
import com.example.rentishaapp.ui.theme.pages.home.ListingScreen
import com.example.rentishaapp.ui.theme.pages.home.ProfileScreen
import com.example.rentishaapp.ui.theme.pages.login.LoginScreen
import com.example.rentishaapp.ui.theme.pages.signup.SignupScreen
import com.example.rentishaapp.ui.theme.pages.splashscreen.SplashScreen
import com.example.rentishaapp.ui.theme.pages.view.ViewScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_SPLASH_SCREEN
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Listings.route){
            ListingScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }
        composable(ROUTE_SPLASH_SCREEN){
            SplashScreen(navController)
        }
        composable(ROUTE_VIEW_SCREEN){
            ViewScreen(navController)
        }
        composable(ROUTE_ADD_LISTING){
            AddListingScreen(navController)
        }
    }
    
}