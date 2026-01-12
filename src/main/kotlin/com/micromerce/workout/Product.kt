package com.micromerce.workout

class Product {
    var id: Int
    var name: String?
    var price: Double?
    var description: String?

    constructor(id: Int, name: String?, price: Double?, description: String?) {
        this.id = id
        this.name = name
        this.price = price
        this.description = description
    }
}