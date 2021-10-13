package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnView: Button = findViewById(R.id.btnView)
        var statusTextView:TextView = findViewById(R.id.textView)
        btnView.setOnClickListener{
            statusTextView.text = "short"
        }
        btnView.setOnLongClickListener{
            //파라미터 한개는 받고있다는 뜻으로 View 뜸
            statusTextView.text = "long"
            false
        }
    }
}