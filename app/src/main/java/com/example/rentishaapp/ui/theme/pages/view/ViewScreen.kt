package com.example.rentishaapp.ui.theme.pages.view

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentishaapp.R
import com.example.rentishaapp.ui.theme.Home
import com.example.rentishaapp.ui.theme.RentishaAppTheme

@Composable
fun ViewScreen(navController: NavHostController) {
    Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
        val images = listOf(
            R.drawable.nyumba,
            R.drawable.livingroom,
            R.drawable.kitchen,
            R.drawable.bedroom,
            R.drawable.bathroom
        )
        ImageSlider(images = images)

        Text(text = "Home")
        Text(text = "Apartment 1bedroom very spacious,\n" +
                "\n" +
                "With a balcony from the sitting room kitchen is very spacious,\n" +
                "\n" +
                "With borehole water council water available enough parking secure compound inclusive service charge",)

        Button(onClick ={},
            colors = ButtonDefaults.buttonColors(Home)
        ) {
            Text(text = "Book")
        }
    }
}


@Composable
fun ImageItem(imageRes: Int){
    Image(painter = painterResource(id = imageRes),
        contentDescription = "null",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(top = 50.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(200.dp),
        )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(images: List<Int>){

    val pageCount = images.size
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){
        5
    }
    HorizontalPager(
        state = pagerState
    ) {page ->
        ImageItem(imageRes = images[page])
    }
    Row(
        modifier = Modifier
            .padding(bottom = 300.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
       ){
        repeat(pageCount){iteration->
            val color = if (pagerState.currentPage == iteration) Color.Red else Color.Black
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ViewScreenPreview() {
    RentishaAppTheme {
        ViewScreen(rememberNavController())
    }
}