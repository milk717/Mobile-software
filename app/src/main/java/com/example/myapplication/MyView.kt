package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.view.View

class MyView(context: Context): View(context) {
    private val b: Bitmap = BitmapFactory.decodeResource(
        resources, R.drawable.harubang)
    private val w:Int = b.width // 하루방 bitmap 너비
    private val h:Int = b.height // 하루방 bitmap 높이

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (canvas == null) return
        canvas.drawColor(Color.LTGRAY)

        canvas.drawBitmap(b, 0f, 0f, null)

        // 하루방 왼쪽 눈 부분
        val src = Rect(40, 40, 140, 140)

        var pi = w + 50
        val dst = Rect(pi, 0, pi + w, h)
        canvas.drawBitmap(b, src, dst, null)

        var pj = h + 50
        val dst2 = Rect(pi, pj, pi + w/2, pj + h/2)
        canvas.drawBitmap(b, src, dst2, null)
    }
}