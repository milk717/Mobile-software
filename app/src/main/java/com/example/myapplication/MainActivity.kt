package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private var status:Boolean = false

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtTime:TextView = findViewById(R.id.txtTime)
        var btnNow: Button = findViewById(R.id.btnNow)
        var btnToggleButton:Button = findViewById(R.id.btnToggle24)

        btnNow.setOnClickListener {
            val date = LocalDateTime.now()
            txtTime.text = getTimeView(date.hour, date.minute)
        }
        btnToggleButton.setOnClickListener {
            status = !status
            val date = LocalDateTime.now()
            txtTime.text = getTimeView(date.hour, date.minute)
        }
    }
    private fun getTimeView(h:Int, m:Int):String {
        var sb = StringBuilder()
        if (status)
            sb.append("$h:$m")
        else {
            if (h > 12)
                sb.append("${h - 12}:$m PM")
            else
                sb.append("$h:$m AM")
        }
        return sb.toString()
    }
}

