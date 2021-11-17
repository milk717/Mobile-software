package com.example.myapplication

import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {
    var fruitList = listOf<Fruit>(
        Fruit("Apple", R.drawable.apple),
        Fruit("Banana", R.drawable.banana),
        Fruit("Grape", R.drawable.grape),
        Fruit("Orange", R.drawable.orange),
        Fruit("Papaya", R.drawable.papaya),
        Fruit("Pineapple", R.drawable.pineapple),
        Fruit("Strawberry", R.drawable.strawberry),
        Fruit("Watermelon", R.drawable.watermelon))
}