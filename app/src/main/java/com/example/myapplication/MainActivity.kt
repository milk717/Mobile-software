package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    private var toggleImage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView =findViewById(R.id.nightImageView)
        val textView: TextView = findViewById(R.id.desTextView)
        imageView.setOnClickListener {
            if (toggleImage) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.INVISIBLE
            }
            toggleImage = !toggleImage
        }
    }
}
