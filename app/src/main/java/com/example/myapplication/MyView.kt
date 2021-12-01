package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.view.View

class MyView(context: Context): View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return

        canvas.drawColor(Color.LTGRAY)

        val paint = Paint()
        val b:Bitmap = BitmapFactory.decodeResource(resources,
            R.drawable.harubang)
        canvas.drawBitmap(b,0f,0f,null)

        paint.textSize = 50f
        var px = 500f
        var py = 100f
        canvas.drawText(width.toString(), px, py, paint)
        canvas.drawText(height.toString(), px+150f, py, paint)

        py += 100f
        canvas.drawText(b.width.toString(), px, py, paint)
        canvas.drawText(b.height.toString(), px+150f, py, paint)
    }
}