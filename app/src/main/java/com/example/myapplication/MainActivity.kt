package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var status:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timePicker:TimePicker = findViewById(R.id.timePicker)
        var txtTime:TextView = findViewById(R.id.txtTime)
        var btnToggle24: Button = findViewById(R.id.btnToggle24)

        timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            txtTime.text = getTime(hourOfDay,minute)
        }

        btnToggle24.setOnClickListener {
            status = !status
        }
    }

    private fun getTime(h:Int, m:Int):String{
        var sb = StringBuilder()
        if(status)
            sb.append("$h:$m")
        else{
            if(h>12) sb.append("${h-12}:$m PM")
            else sb.append("$h:$m AM")
        }
        return sb.toString()
    }
}

