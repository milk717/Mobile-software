package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//                      클래스 상속            인터페이스 상
//클래스 상속은 조상이 하나, 인터페이스 상속은 여러개 받을 수 있다.
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnView: Button = findViewById(R.id.btnView)
        btnView.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        Toast.makeText(
            applicationContext,
            "버튼이 눌렸습니다",
            Toast.LENGTH_SHORT
        ).show()
    }
}