package com.example.myapplication

import androidx.lifecycle.ViewModel

class FruitViewModel: ViewModel() {
    var fruit: Fruit? = null
        set(fruit) {
            field = fruit
        }

    val name: String?
        get() = fruit?.name

    val fruits: List<Fruit>

    init {
        fruits = loadFruits()
    }
    private fun loadFruits(): List<Fruit> {
        val fruits = mutableListOf<Fruit>()
        fruits.add(Fruit("Apple"))
        fruits.add(Fruit("Apricot"))
        fruits.add(Fruit("Avocado"))
        fruits.add(Fruit("Banana"))
        fruits.add(Fruit("Blueberry"))
        fruits.add(Fruit("Blackberry"))
        fruits.add(Fruit("Cherry"))
        fruits.add(Fruit("Coconut"))
        fruits.add(Fruit("Cranberry"))
        fruits.add(Fruit("Grape raisin"))
        fruits.add(Fruit("Honey dew"))
        fruits.add(Fruit("Lemon"))
        fruits.add(Fruit("Lime"))
        fruits.add(Fruit("Mango"))
        fruits.add(Fruit("Watermelon"))

        return fruits
    }
}