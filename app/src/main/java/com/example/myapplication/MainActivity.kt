package com.example.myapplication

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calendar: CalendarView = findViewById(R.id.calendar)
        var date_view: TextView = findViewById(R.id.date_view)

        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            date_view.text = String.format(
                Locale.KOREA,
                "%d-%d-%d", year, month + 1, dayOfMonth
            )
        }
    }

}

