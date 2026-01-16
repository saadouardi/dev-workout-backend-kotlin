package com.micromerce.workout.controller

import com.micromerce.workout.model.Cart
import com.micromerce.workout.model.Product
import com.micromerce.workout.data.Products

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
    fun addToCart(@RequestBody requestProduct: Product) {
        val foundProduct = Products.findById(requestProduct.id)
        if (foundProduct != null) {
            cart.addProduct(foundProduct)
        }
    }

    @PostMapping("/removeItemFromCart")
    fun removeFromCart(@RequestBody id: Int) {
        val product = Products.findById(id)
        if (product != null) {
            cart.removeProduct(product)
        }
    }
}