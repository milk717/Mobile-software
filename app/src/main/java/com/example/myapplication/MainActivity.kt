package com.example.myapplication

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val startButton = findViewById<Button>(R.id.startButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        val rocketAnim: AnimationDrawable = imageView.background as AnimationDrawable

        startButton.setOnClickListener {
            rocketAnim.start()
        }
        stopButton.setOnClickListener {
            rocketAnim.stop()
        }
    }


}