package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    private val TAG = "Unit Conversion"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scale:Float =resources.displayMetrics.density
        Log.i(TAG,"density = $scale") //비율 : px = dp = scale

        var dpi = (scale*160).toInt()
        Log.i(TAG,"dpi = $dpi")

        val dp = 16
        var px = (scale*dp+0.5).toInt() //정수는 1.7 -> 1, 1.7 + 0.5 -> 2.2 ->2
        Log.i(TAG,"dp = $dp, px = $px")
    }
}