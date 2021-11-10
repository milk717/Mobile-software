package com.example.myapplication

import android.os.Bundle
import android.view.WindowManager
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        ratingBar.setOnRatingBarChangeListener{_, rating, _ ->
            Toast.makeText(applicationContext, "점수:$rating",Toast.LENGTH_SHORT).show()
        }

        val textView: TextView = findViewById(R.id.textView)
        val seekBar: SeekBar = findViewById(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = "seek value = $progress"
                setBrightness(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                textView.text = "seek value = ${seekBar?.progress}"
            }
        })
    }
    //밝기조절 함수
    private fun setBrightness(b:Int){
        var bright = b
        if(bright < 10) bright = 10
        else if(bright > 100) bright = 100
        var lp = window.attributes  //윈도우가 갖고있는 값
        lp.alpha = (bright.toFloat())/100F
        lp.flags = (lp.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.attributes = lp
    }
}

