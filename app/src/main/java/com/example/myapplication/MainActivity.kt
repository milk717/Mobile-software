package com.example.myapplication

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE_STR = "com.example.myapplication.message"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)

        button.setOnClickListener {
            var str = editText.text.toString()

            //ComponentName(package, activity)
            var cn = ComponentName("com.example.myapplication", "com.example.myapplication.SubActivity")
            var i = Intent()
                .apply {
                    component = cn
                    putExtra(EXTRA_MESSAGE_STR,str)
                }

            startActivity(i)
        }
    }
}

