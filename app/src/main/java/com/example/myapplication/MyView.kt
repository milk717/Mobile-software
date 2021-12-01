package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View

class MyView(context: Context): View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return
        canvas.drawRGB(255, 255, 0)
        val paint = Paint()
        paint.textSize = 50f

        var t = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        paint.typeface = t
        canvas.drawText("DEFAULT 폰트", 10f, 100f, paint)

        t = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
        paint.typeface = t
        canvas.drawText("MONOSPACE 폰트", 10f, 200f, paint)

        t = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC)
        paint.typeface = t
        canvas.drawText("SERIF 폰트", 10f, 300f, paint)

        t = Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC)
        paint.typeface = t
        canvas.drawText("SANS_SERIF 폰트", 10f, 400f, paint)
    }
}