package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyView:View{
    //부모클래스가 있으니까 super 키워드 사용
    constructor(context: Context):super(context){
        setBackgroundColor(Color.YELLOW)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(canvas == null) return

        val w = width.toFloat()
        val h = height.toFloat()

        val paint = Paint()
        paint.setARGB(255,255,0,0)
        paint.strokeWidth = 10f
        canvas.drawLine(0f,50f,w,50f,paint) //null-safety, 붓 객체 생성해야 에러 안남
        canvas.drawLine(0f,h-50f,w,h-50f,paint)
        canvas.drawLine(50f,0f,50f,h,paint)
        canvas.drawLine(w-50f,0f,w-50f,h,paint)
    }
}