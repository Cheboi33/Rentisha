package com.example.rentishaapp.ui.theme.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rentishaapp.R
import com.example.rentishaapp.ui.theme.Home
import com.example.rentishaapp.ui.theme.RentishaAppTheme
import com.example.rentishaapp.ui.theme.rangi
import com.example.rentishaapp.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListingScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = rangi,
                    titleContentColor = white,
                ),
                title = {
                    Text(text = "My Listings")
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            listOf(
                1,2,3,4,5,6,7,8
            ).forEach { item ->  Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(width = 400.dp, height = 200.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .background(color = white)
                            .size(
                                height = 170.dp,
                                width = 120.dp
                            )
                    ) {
                        Image(painter = painterResource(
                            id = R.drawable.nyumba),
                            contentDescription = "null",
                            modifier = Modifier.height(250.dp),
                            contentScale = ContentScale.FillHeight)
                    }
                    Column {
                        Text(
                            text = "Property Name",
                            modifier = Modifier
                                .padding(16.dp),
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            text = "Property description",
                            modifier = Modifier
                                .padding(16.dp),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(25.dp))

                        Row(modifier = Modifier
                            .padding(8.dp),

                            ){
                            Button(
                                onClick = {
                                },
                                colors = ButtonDefaults.buttonColors(Home)
                            ) {
                                Text(text = "View")
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            Button(
                                onClick = {
                                },
                                colors = ButtonDefaults.buttonColors(Home)
                            ) {
                                Text(text = "Book")
                            }
                        }
                    }
                }
            } }

        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun ListingScreenPreview() {
    RentishaAppTheme {
        ListingScreen()
    }
}
