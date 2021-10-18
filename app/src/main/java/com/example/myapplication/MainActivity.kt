package com.example.myapplication

import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBarListener =
            RatingBar.OnRatingBarChangeListener { _, rating, _ -> showToast("평점은 $rating") }

        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        ratingBar.onRatingBarChangeListener = ratingBarListener

    }
    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}