package com.example.rentishaapp.models

class User {
    var name:String = ""
    var email:String = ""
    var password:String = ""
    var uid:String = ""

    constructor(name: String, email: String, password: String, uid: String) {
        this.name = name
        this.email = email
        this.password = password
        this.uid = uid
    }
//    constructor()
}