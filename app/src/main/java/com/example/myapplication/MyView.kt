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

        try{
            val myFont = Typeface.createFromAsset(
                context.assets,"ScriptoniteDemo.ttf")   //context가 asstes을 관리함, 폰트이름 정확히
            paint.typeface = myFont
            canvas.drawText("This is a new font.", 10f, 100f, paint)
            canvas.drawText("Have fun!", 10f, 200f, paint)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}