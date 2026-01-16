package com.micromerce.workout.controller
import com.micromerce.workout.model.Product
import com.micromerce.workout.data.Products

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsController {
    @RequestMapping
    fun getProducts(): List<Product> {
        return Products.products
    }
}