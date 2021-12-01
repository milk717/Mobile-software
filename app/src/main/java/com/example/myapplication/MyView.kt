package com.example.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.view.View

class MyView(context: Context): View(context) {
    private val b: Bitmap = BitmapFactory.decodeResource(
        resources, R.drawable.harubang)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (canvas == null) return
        canvas.drawColor(Color.LTGRAY)

        //비트맵 공간을 만듬.
        val mBitmap = Bitmap.createBitmap(600,600,
            Bitmap.Config.ARGB_8888)
        //아까 만든 비트맵 공간을 캔버스에 넣음?
        val mCanvas = Canvas(mBitmap)
        mCanvas.drawColor(Color.YELLOW)

        //노란색 mCanvas 안에서의 돌하르방 위치
        //노란색 mCanvas 안에 돌하르방을 그림
        mCanvas.drawBitmap(b,20f,20f,null)

        //회색 전체 캔버스에서 노란색 mCanvas 의 위치
        //전체 캔버스 안에 노란색 mCanvas 를 그림
        canvas.drawBitmap(mBitmap,50f,50f,null)
    }
}