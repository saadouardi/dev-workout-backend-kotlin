package com.micromerce.workout

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