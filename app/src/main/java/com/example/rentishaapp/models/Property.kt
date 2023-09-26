package com.example.rentishaapp.models

class Property {
    var name:String = ""
    var price:String = ""
    var description:String = ""
    var id:String = ""

    constructor(name: String, price: String, description: String, id: String) {
        this.name = name
        this.price = price
        this.description = description
        this.id = id
    }
    constructor()
}