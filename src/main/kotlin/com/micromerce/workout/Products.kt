package com.micromerce.workout

object Products {
    val products = listOf(
        Product(1, "Laptop", 899.99, "A high-performance laptop suitable for all your computing needs."),
        Product(2, "Mouse", 24.99, "Ergonomic wireless mouse with adjustable DPI settings."),
        Product(3, "Keyboard", 79.99, "Mechanical keyboard with customizable RGB lighting."),
        Product(4, "Monitor", 299.99, "27-inch 4K UHD monitor with vibrant colors and sharp details."),
        Product(5, "Headset", 59.99, "Comfortable over-ear headset with noise-canceling microphone."),
        Product(6, "USB Stick", 4.99, "32GB USB 3.0 flash drive for fast data transfer.")
    )

    fun findById(id: Int): Product? {
        return products.find { it.id == id }
    }
}