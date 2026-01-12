package com.micromerce.workout

data class Cart(
    val products: MutableList<Product> = mutableListOf()
) {
    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(product: Product?) {
        products.remove(product)
    }

    fun getTotalPrice(): Double {
        return products.sumOf { it.price ?: 0.0 }
    }
}