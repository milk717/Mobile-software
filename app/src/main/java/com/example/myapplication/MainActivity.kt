package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var toggleImage:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onButtonClicked(view: View){
        var iv: ImageView = findViewById(R.id.imageView)
        var iv2: ImageView = findViewById(R.id.imageView2)

        if(toggleImage){
            iv.visibility = View.VISIBLE
            iv2.visibility = View.INVISIBLE
        }else{
            iv.visibility = View.INVISIBLE
            iv2.visibility = View.VISIBLE
        }
        toggleImage = !toggleImage
    }
}