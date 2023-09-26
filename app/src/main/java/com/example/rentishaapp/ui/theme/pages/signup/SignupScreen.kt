package com.example.rentishaapp.ui.theme.pages.signup

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rentishaapp.data.AuthRepository
import com.example.rentishaapp.navigation.ROUTE_LOGIN
import com.example.rentishaapp.ui.theme.Home
import com.example.rentishaapp.ui.theme.RentishaAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavHostController) {
    var context = LocalContext.current
   Scaffold(
       content = {
           Column(modifier = Modifier.fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally) {

               Text(
                   text = "Signup here",
                   fontSize = 35.sp,
                   fontFamily = FontFamily.Cursive,
                   color = Color.Black,
                   modifier = Modifier.padding(40.dp),
                   fontWeight = FontWeight.Bold,
                   textDecoration = TextDecoration.Underline
               )

               var name by remember { mutableStateOf(TextFieldValue("")) }
               var email by remember { mutableStateOf(TextFieldValue("")) }
               var password by remember { mutableStateOf(TextFieldValue("")) }

               OutlinedTextField(
                   value = name,
                   onValueChange = { name = it },
                   label = { Text(text = "Name *") },
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
               )

               Spacer(modifier = Modifier.height(20.dp))

               OutlinedTextField(
                   value = email,
                   onValueChange = { email = it },
                   label = { Text(text = "Email *") },
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
               )

               Spacer(modifier = Modifier.height(20.dp))

               OutlinedTextField(
                   value = password,
                   onValueChange = { password = it },
                   label = { Text(text = "Password") },
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
               )

               Spacer(modifier = Modifier.height(20.dp))

               Button(onClick = {
                   //SIGNUP LOGIC
                   println(name.text)
                   var authRepository = AuthRepository(navController, context.applicationContext)
                   authRepository.signup(name.text, email.text, password.text)},
                   colors = ButtonDefaults.buttonColors(Home)) {
                   Text(text = "Signup")
               }
               Spacer(modifier = Modifier.height(20.dp))
               Button(onClick = {
                   navController.navigate(ROUTE_LOGIN)},
                   colors = ButtonDefaults.buttonColors(Home)) {
                   Text(text = "Have an account?Login")
               }
           }
       }
   )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun SignupScreenPreview() {
    RentishaAppTheme {
        SignupScreen(rememberNavController())
    }
}