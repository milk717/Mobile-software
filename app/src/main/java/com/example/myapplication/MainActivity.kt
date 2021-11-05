package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.callButton).setOnClickListener {
            val intent = Uri.parse("tel:(+82)01012345678").let{ number->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(intent)
        }
    }
}

