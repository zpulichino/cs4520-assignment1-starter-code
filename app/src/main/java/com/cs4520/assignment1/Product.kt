package com.cs4520.assignment1

sealed class Product(val name: String, val price: Int) {
    class Equipment(name: String, price: Int) : Product(name, price)
    class Food(name: String, price: Int, val expiryDate: String?) : Product(name, price)
}