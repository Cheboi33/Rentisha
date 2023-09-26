package com.example.rentishaapp.ui.theme.pages.home

import android.content.res.Configuration
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.rentishaapp.R
import com.example.rentishaapp.navigation.ROUTE_LOGIN
import com.example.rentishaapp.ui.theme.Home
import com.example.rentishaapp.ui.theme.RentishaAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .wrapContentSize(Alignment.Center)
    ){
    }

    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current,notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""

    }

    var name by rememberSaveable{ mutableStateOf("Name") }
    var email by rememberSaveable { mutableStateOf("Email") }
    var phoneNumber by rememberSaveable { mutableStateOf(" Phone Number") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Cancel",
                modifier = Modifier.clickable { notification.value = "Cancelled" })
            Text(
                text = "Save",
                modifier = Modifier.clickable { notification.value = "Saved" }
                )
        }
        ProfileImage()

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
        Text(text = "Name", modifier = Modifier.width(100.dp))
        TextField(
            value = name,
            onValueChange ={name = it},
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color.Transparent,
                textColor = Color.Black
            )
          )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Email", modifier = Modifier.width(100.dp))
            TextField(
                value = email,
                onValueChange ={email = it},
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor = Color.Transparent,
                    textColor = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Phone number", modifier = Modifier.width(100.dp))
            TextField(
                value = phoneNumber,
                onValueChange ={phoneNumber= it},
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor = Color.Transparent,
                    textColor = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)},
            colors = ButtonDefaults.buttonColors(Home)
        ) {
            Text(text = "Logout")
        }
    }
}

@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable{ mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.user
        else
        imageUri.value
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){uri: Uri? ->
      uri?.let { imageUri.value.toString() }
    }


    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Card(
        shape = CircleShape,
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
    ) {
    Image(painter = painter,
        contentDescription = null,
        modifier = Modifier
            .wrapContentSize()
            .clickable { launcher.launch("image/*") },
        contentScale = ContentScale.Crop
        )
    }
        Text(text = "Change profile picture")
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun ProfileScreenPreview() {
    RentishaAppTheme {
        ProfileScreen(rememberNavController())
    }
}