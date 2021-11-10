package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        progressBar.progress = 0

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            //앞뒤에 공백이 있을 때는 trim() 사용
            var pval = Integer.parseInt(editText.text.toString().trim())
            if (pval in 1..100)
                progressBar.progress = pval
            else {
                progressBar.progress = 0
                Toast.makeText(this, "값 설정 에러: $pval",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun convertInt(s:String):Int {
        return Integer.parseInt(s)
    }
}

