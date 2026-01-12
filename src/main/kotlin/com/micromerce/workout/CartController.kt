package com.micromerce.workout

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cart")
class CartController {
    private var cart: Cart = Cart(mutableListOf())

    @GetMapping("/items")
fun cartItems() = cart

    @PostMapping("/addItem")
    fun addToCart(@RequestBody product: Product) {
        val product = Products.findById(product.id)
        if (product != null) {
            cart.addProduct(product)
        }
    }

    @PostMapping("/removeItemFromCart")
    fun removeFromCart(id: Int) {
        cart.removeProduct(Products.findById(id))
    }
}