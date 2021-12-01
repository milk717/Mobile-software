package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class MyView : View {
    constructor(context: Context): super(context)  {
        setBackgroundColor(Color.YELLOW)
    }
    //코틀린 코드에서 만든 것을 xml 에 포함시킬 때 반드시 필요한 생성자
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)  {
        setBackgroundColor(Color.YELLOW)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return

        val paint = Paint()
        val r = RectF(100f, 100f, 300f, 300f)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        canvas.drawRect(r, paint)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas.drawArc(r, 90f, 270f, false, paint)
    }
}