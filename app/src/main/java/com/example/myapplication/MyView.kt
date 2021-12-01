package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.view.View

class MyView(context:Context): View(context) {
    lateinit var myBitmap:Bitmap
    lateinit var myCanvas:Canvas

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        myBitmap = Bitmap.createBitmap(
            w, h, Bitmap.Config.ARGB_8888)
        myCanvas = Canvas(myBitmap)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        myCanvas.drawColor(Color.BLUE)

        drawMirrorBitmap()
        canvas?.drawBitmap(myBitmap, 0f, 0f, null)
    }
    private fun drawMirrorBitmap() {
        var bobBitmap: Bitmap = BitmapFactory.decodeResource(
            resources, R.drawable.bob)

        myCanvas.drawBitmap(bobBitmap, 25f, 25f, null)
        val matrix = Matrix()
        matrix.preScale(1f, -1f)
        val w = bobBitmap.width
        val h = bobBitmap.height
        var bobBitmap2 = Bitmap.createBitmap(bobBitmap,
            0, 0, w, h, matrix, false)

        myCanvas.drawBitmap(bobBitmap2, 25f, h+50f, null)
        matrix.preRotate(-90f)
        var bobBitmap3 = Bitmap.createBitmap(bobBitmap,
            0, 0, w, h, matrix, false)
        myCanvas.drawBitmap(bobBitmap3, 25f, 2*h+50f, null)
    }
}

