package com.example.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.view.View

class MyView(context: Context): View(context) {
    private val mBitmap = Bitmap.createBitmap(600,600,
        Bitmap.Config.ARGB_8888)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val mCanvas = Canvas(mBitmap)
        mCanvas.drawColor(Color.YELLOW)
        val b: Bitmap = BitmapFactory.decodeResource(
            resources, R.drawable.harubang)
        mCanvas.drawBitmap(b,20f,20f,null)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (canvas == null) return
        canvas.drawColor(Color.LTGRAY)
        canvas.drawBitmap(mBitmap,50f,50f,null)
    }
}