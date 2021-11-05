package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        //null-safety 처리 필수
        var msg:String? = intent.getStringExtra(EXTRA_MESSAGE_STR)
        val editText: EditText = findViewById(R.id.editText)
        editText.setText("수신 메시지는 $msg")

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            finish()
        }
    }
}