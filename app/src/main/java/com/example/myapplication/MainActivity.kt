package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val ratingBarListener =
//            RatingBar.OnRatingBarChangeListener { _, rating, _ ->
//                showToast("평점은 $rating")
//            }
//
          val ratingBar: RatingBar = findViewById(R.id.ratingBar)
//        ratingBar.onRatingBarChangeListener = ratingBarListener

        val button: Button = findViewById(R.id.button)  //버튼을 불러오고
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var rating = ratingBar.rating.toString()
                showToast("평점은 $rating")
            }
        })

    }
    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}