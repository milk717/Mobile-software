package com.example.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.view.View

class MyView(context:Context): View(context) {
    lateinit var myBitmap: Bitmap
    lateinit var myCanvas: Canvas

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        myBitmap = Bitmap.createBitmap(
            w, h, Bitmap.Config.ARGB_8888)
        myCanvas = Canvas(myBitmap)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        myCanvas.drawColor(Color.BLUE)

        drawEnlargedBitmap()
        canvas?.drawBitmap(myBitmap, 0f, 0f, null)
    }

    private fun drawEnlargedBitmap() {
        var bobBitmap: Bitmap = BitmapFactory.decodeResource(
            resources, R.drawable.bob)
        myCanvas.drawBitmap(bobBitmap, 25f, 25f, null)

        bobBitmap = Bitmap.createScaledBitmap(bobBitmap,
            300, 400, false)
        val w = bobBitmap.width
        myCanvas.drawBitmap(bobBitmap, w+25f, 25f, null)
    }
}
