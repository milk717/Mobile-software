package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class MyView(context: Context) : View(context) {
    init {
        setBackgroundColor(Color.BLUE)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return
        val paint = Paint()
        val r1 = RectF(10f, 10f, 110f, 110f)
        val r2 = RectF(150f, 10f, 350f, 100f)
        val r3 = RectF(10f, 120f, 110f, 220f)

        paint.color = Color.YELLOW
        //canvas.drawRoundRect(r1, 5f, 5f, paint)
        canvas.drawRect(r1,paint)

        canvas.drawOval(r2, paint)

        paint.color = Color.RED
        //호그리기, true 는 호의 끝부분이 중심이랑 연결됨
        canvas.drawArc(r3, 120f, 270f, true, paint)

        paint.color = Color.YELLOW
        paint.strokeWidth = 10f
        val pts = floatArrayOf(10f, 250f, 100f, 270f,
            100f, 270f, 20f, 290f,
            20f, 290f, 120f, 300f)
        canvas.drawLines(pts, paint)
    }
}