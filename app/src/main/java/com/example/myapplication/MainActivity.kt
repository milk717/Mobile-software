package com.example.myapplication

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val srchEditText:EditText = findViewById(R.id.editText)
        srchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                Toast.makeText(
                    applicationContext,
                    "탐색 문자열은 ${srchEditText.text}",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            false
        }
    }
}