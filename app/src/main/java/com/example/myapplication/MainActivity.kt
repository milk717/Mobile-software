package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE_STR = "com.example.intentsample.message"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)

        button.setOnClickListener {
            var str = editText.text.toString()
            var i = Intent(this, SubActivity::class.java)
            i.putExtra(EXTRA_MESSAGE_STR, str)
            startActivity(i)
        }
    }

}

