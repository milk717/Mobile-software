package com.example.myapplication;

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class BitmapButton(context: Context) : AppCompatButton(context){
    init{
        AppCompatButton(context)
        initialize()
    }

    constructor(context: Context, attrs:AttributeSet):this(context){
        AppCompatButton(context, attrs)
        initialize()
    }
    private fun initialize(){
        setBackgroundColor(R.drawable.bitmap_button_normal)
        text = "Bitmap Button"
        isAllCaps = false
        textSize = 24.0f
        setTextColor(Color.parseColor("#FFFFFF"))
        setPadding(50, 10, 50, 10)
        typeface = Typeface.DEFAULT_BOLD
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)

        if(event == null)
            return false

        when (event.action){
            MotionEvent.ACTION_DOWN -> setBackgroundResource(R.drawable.bitmap_button_clicked)
            MotionEvent.ACTION_UP -> setBackgroundResource(R.drawable.bitmap_button_normal)
            else ->
                setBackgroundResource(R.drawable.bitmap_button_normal)
        }
        invalidate()
        return true
    }
}
