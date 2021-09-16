package com.example.myapplication

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun onBtnClicked(view: View){
            val dollars = findViewById<EditText>(R.id.dollarsInput)
            val txt = findViewById<TextView>(R.id.result_text)
            if(dollars.text.isNotEmpty()){
                val dollarValue = dollars.text.toString().toFloat()
                val wonValue = dollarValue * 1136

                val color = ContextCompat.getColor(this, R.color.custom)
                val dp = resources.getDimension(R.dimen.textSize)
                txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP,dp)
                txt.setTextColor(color)
                txt.text = wonValue.toString()
            }
            else{
                txt.text = "No Value"
            }
        }
    }

}