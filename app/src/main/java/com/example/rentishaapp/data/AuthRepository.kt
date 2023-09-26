package com.example.rentishaapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.rentishaapp.navigation.ROUTE_HOME
import com.example.rentishaapp.navigation.ROUTE_LOGIN
import com.example.rentishaapp.navigation.ROUTE_SIGNUP
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthRepository(var navController: NavHostController, var context: Context) {
    val mAuth:FirebaseAuth
    val progress: ProgressDialog
    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("please wait..")
    }
    fun signup(name:String, email:String, password:String){

        print(name)
        print(email)
//        progress.show()
        var mAuth: FirebaseAuth  = FirebaseAuth.getInstance()
       mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            progress.dismiss()

            if(it.isSuccessful){
                var regRef = FirebaseDatabase.getInstance().getReference()
                    .child("Users/"+mAuth.currentUser!!.uid)
                regRef.setValue(it.result.user?.uid).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context, "Signup successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                    } else{
                        Toast.makeText(context, "ERROR:${it.exception!!.message}", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_LOGIN
                        )
                    }
                }
            } else{
                navController.navigate(ROUTE_SIGNUP)
            }
        }
    }
    fun login(email: String, password: String){
        progress.show()
//        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//            progress.dismiss()
//            if (it.isSuccessful){
//                Toast.makeText(context,"Login successful", Toast.LENGTH_SHORT).show()
//                navController.navigate(ROUTE_HOME)
//            }else{
//
//                navController.navigate(ROUTE_LOGIN)
//            }
//        }

    }

    fun isLoggedIn():Boolean = mAuth.currentUser != null
}