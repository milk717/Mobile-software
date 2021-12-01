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

        drawRotatedBitmap()
        canvas?.drawBitmap(myBitmap, 0f, 0f, null)
    }

    private fun drawRotatedBitmap() {
        var bobBitmap: Bitmap = BitmapFactory.decodeResource(
            resources, R.drawable.bob
        )

        val w = bobBitmap.width
        val h = bobBitmap.height
        var rotatedBitmap: Bitmap? = null

        var rotation = 0f
        var horizontalPos = 50f
        var verticalPos = 25f
        val matrix = Matrix()

        while (rotation < 360) {
            matrix.reset()

            // M' = M*R(degrees), 시계방향 회전
            matrix.preRotate(rotation)

            // 원점(0,0), 너비(w), 높이(h)
            // 위치 이동만이 아닌 다른 변환도 포함되었을 경우에만 true 설정
            rotatedBitmap = Bitmap.createBitmap(
                bobBitmap, 0, 0, w, h, matrix, true
            )

            // 이미지 출력 위치(horizontalPos, verticalPos)
            // 회전할 때마다 오른쪽으로 120, 아래쪽으로 70씩 이동
            myCanvas.drawBitmap(
                rotatedBitmap,
                horizontalPos, verticalPos, null
            )

            horizontalPos += w
            verticalPos += h
            rotation += 30f
        }
    }
}


