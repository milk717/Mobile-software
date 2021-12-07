package com.example.myapplication

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rect_image = findViewById<ImageView>(R.id.rect_image)
        val translate = findViewById<Button>(R.id.translate)
        val rotate = findViewById<Button>(R.id.rotate)
        val scale = findViewById<Button>(R.id.scale)
        val alpha = findViewById<Button>(R.id.alpha)

        translate.setOnClickListener {
            var anim: Animation = AnimationUtils.loadAnimation(this, R.anim.translate)
            rect_image.startAnimation(anim)
        }
        rotate.setOnClickListener {
            var anim: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            rect_image.startAnimation(anim)
        }
        scale.setOnClickListener {
            var anim: Animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            rect_image.startAnimation(anim)
        }
        alpha.setOnClickListener {
            var anim: Animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
            rect_image.startAnimation(anim)
        }
    }
}
