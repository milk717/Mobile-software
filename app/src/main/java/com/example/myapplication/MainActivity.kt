package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnView: Button = findViewById(R.id.btnView)
        var statusTextView:TextView = findViewById(R.id.textView)
        btnView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                statusTextView.text = "short"
            }
        })
        btnView.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                statusTextView.text = "long"
                return false        //true 반환하면 얘가 완벽하게 처리한거여서 다른데로 안넘어감 false 하면 종료 후 다른 메소드로 넘어감
            }
        })
    }
}