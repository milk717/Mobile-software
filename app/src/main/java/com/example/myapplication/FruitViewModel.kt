package com.example.myapplication

import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {
    val fruitList = listOf(
        Fruit("Apple"),
        Fruit("Apricot"),
        Fruit("Avocado"),
        Fruit("Banana"),
        Fruit("Blackberry"),
        Fruit("Blueberry"),
        Fruit("Cherry"),
        Fruit("Coconut"),
        Fruit("Cranberry"),
        Fruit("Grape raisin"),
        Fruit("Honey dew"),
        Fruit("Jack fruit"),
        Fruit("Lemon"),
        Fruit("Lime"),
        Fruit("Mango"),
        Fruit("Watermelon")
    )
}