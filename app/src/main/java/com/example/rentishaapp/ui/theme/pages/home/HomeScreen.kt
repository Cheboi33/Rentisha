package com.example.rentishaapp.ui.theme.pages.home


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentishaapp.R
import com.example.rentishaapp.navigation.ROUTE_VIEW_SCREEN
import com.example.rentishaapp.ui.theme.Home
import com.example.rentishaapp.ui.theme.RentishaAppTheme
import com.example.rentishaapp.ui.theme.rangi
import com.example.rentishaapp.ui.theme.white
import androidx.compose.material3.Text as Text2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var search by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = rangi,
                    titleContentColor = white,
                ),
                title = {
                    Text2(text = "Rentisha")
                }
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            OutlinedTextField(
                modifier = Modifier.padding(8.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Navigation Icon"
                    )
                },
                value = search,
                onValueChange = { search = it },
                label = { Text2(text = "Search ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            listOf(
                1, 2, 3, 4, 5, 6, 7, 8, 9
            ).forEach { item ->
                Card(
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
                            Row {
                                Button(onClick = {
                                    navController.navigate(ROUTE_VIEW_SCREEN)},
                                    colors = ButtonDefaults.buttonColors(Home)
                                ) {
                                    Text(text = "View")
                                }
                                Spacer(modifier = Modifier.width(20.dp))
                                Button(onClick ={},
                                    colors = ButtonDefaults.buttonColors(Home)
                                ) {
                                    Text(text = "Book")
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

    @Composable
    @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
    fun HomeScreenPreview() {
        RentishaAppTheme {
            HomeScreen(rememberNavController())
        }
    }