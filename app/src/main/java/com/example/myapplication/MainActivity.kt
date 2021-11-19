package com.example.myapplication

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val dm = resources.displayMetrics
        val str = """
            widthPixels = ${dm.widthPixels}
            heightPixels = ${dm.heightPixels}
            density = ${dm.density}
            scaledDensity = ${dm.scaledDensity}
            densityDpi = ${dm.densityDpi}
            DENSITY_DEFAULT = ${DisplayMetrics.DENSITY_DEFAULT}            
            xdpi = ${dm.xdpi}
            ydpi = ${dm.ydpi}
            """.trimIndent()

        textView.text = str
    }
}