package com.example.rentishaapp.ui.theme.pages.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentishaapp.R
import com.example.rentishaapp.navigation.ROUTE_LOGIN
import com.example.rentishaapp.ui.theme.RentishaAppTheme
import com.example.rentishaapp.ui.theme.ShowBar
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    ShowBar(flag = false)
    
    LaunchedEffect(key1 = true){
        delay(2500)
        navController.navigate(ROUTE_LOGIN){
            popUpTo(0)
        }
    }
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(
                id = R.drawable.home),
            contentDescription = "logo",
            modifier = Modifier.height(120.dp))
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    RentishaAppTheme {
        SplashScreen(rememberNavController())
    }
}