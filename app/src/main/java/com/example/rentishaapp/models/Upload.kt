package com.example.rentishaapp.models

class Upload {
    var name:String = ""
    var price:String = ""
    var description:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, price: String, description: String, imageUrl: String, id: String) {
        this.name = name
        this.price = price
        this.description = description
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}