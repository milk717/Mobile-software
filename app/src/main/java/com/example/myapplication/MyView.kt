package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyView(context: Context) : View(context) {
    init {
        setBackgroundColor(Color.BLACK)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.setARGB(255, 255, 255, 255)   // white

        for (x in 1..1000) {
            var dx = (Math.random() * width).toFloat()
            var dy = (Math.random() * height).toFloat()
            canvas?.drawPoint(dx, dy, paint)
        }
    }
}